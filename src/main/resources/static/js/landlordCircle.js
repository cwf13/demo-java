//----------------------------------------------------评论开始-----------------------------------------------------------
// 唤起评论输入弹窗
$(document).on("click", ".getIn2", function () {
    // 方法一：获取当前的li
    getPar = $(this).parents("li");
    // 方法二：用属性值获取当前的li
    //  t=$(this).parents("li").attr("order");
    // console.log(t);
    layer.closeAll();
    layer.open({
        content: $('.addComment').html(),
        className: 'showEmoji',
        area: ["100%", "100%"],

        success: function () {
            // 为添加表情添加点击监听事件
            addEmoji();

        }
    });
})

// 为添加表情添加点击监听事件
function addEmoji() {
    var editor = easyEditor('easyEditor');

    //表情
    var emojiBtn = document.getElementById('emoji_btn');
    var emojiBox = $(".showEmoji").find("#emoji_list")[0];
    var emojiList = emojiBox.getElementsByTagName('img');
//辦定事件添加表情
    for (var i = 0; i < emojiList.length; i++) {
        addEvent(emojiList[i], 'click', function () {
            var src = this.getAttribute('src');
            editor.insertEmoji({
                src: src,
                remark: '笑脸',
                data: {
                    id: 44
                }
            }); //添加表情
            // emojiBox.style.display = 'none';
        });
    }
}

//事件辦定
function addEvent(element, type, callback) {
    if (element.addEventListener) {
        element.addEventListener(type, callback, false);
    } else if (element.attachEvent) {
        element.attachEvent('on' + type, callback)
    }
}

// 正则转换
function htmlEncode(html) {
    var temp = document.createElement("div");
    (temp.textContent != undefined) ? (temp.textContent = html) : (temp.innerText = html);
    var output = temp.innerHTML;
    temp = null;
    return output;
}

// 表情列表的显示隐藏切换
function emojibtn() {
    $(".showEmoji #emoji_list").toggle();
}

// 把输入框的评论插入对应的位置
function insert() {
    var txt = $(".layui-m-layercont .inVaule").html();
    if (txt != "") {
        // 方法一：获取li
        $(getPar).find(".right").append('<div class="qp clearfix"><span class="name">nick:</span><div class="msg">' + txt + '</div></div><br/>');
        // 方法二：获取li注意t两边的单引号            // $("li[order='"+t+"']").find(".right").append('<div class="qp clearfix"><span class="name">nick:</span><div class="msg">'+txt+'</div></div><br/>');，单引号只能各一个，单引号不算字符串
        layer.closeAll();

    }
}

//----------------------------------------------------------------------评论结束-----------------------------------------------------------

//----------------------------------------------------------------------发布需求-----------------------------------------------------------
// 唤起发布需求的弹窗
$(document).on("click", "#publishNeed", function () {
    layer.closeAll();
    layer.open({
        content: $('.addCircle').html(),
        className: 'showEmoji',
        area: ["100%", "100%"],

        success: function () {

        }
    });
})

// 发布需求
function publish() {
    var landlordCircleText = $(".layui-m-layercont .upTxt").val();

    if (landlordCircleText == "") {
        layer.open({
            content: "请输入内容哈。",
            skin: 'msg',
            time: 1,
            type: 3,
        });
        return;
    }

    var obj = new Object();
    obj.landlordCircleText = landlordCircleText;

    $.ajax({
        type: "post",
        url: "/landlord/circleSend",
        dataType: "json",
        data: obj,

        success: function (result) {
            console.log(result);
            layer.closeAll();
            window.location.reload();
        }
    });

}

// 房东圈信息列表拼接HTML
var html_1 = '<li class="clearfix" id="{id}">\
            <div class="left">\
              <img src={headImg} alt="">\
           </div>\
           <div class="right">\
             <p class="nick">{userName}</p>\
             <p class="text">{landlordCircleText}</p>\
             <div class="imgMesg clearfix">\
                 <img src={landlordCircleImg} alt="">\
             </div>\
             <div class="inp">\
                 <img src="../static/img/landlordCircle/inMes.png" alt="" class="getIn2">\
             </div>\
          </div>\
      </li>'

// 获取房东圈信息列表
function getCircleList() {
    $.ajax({
        type: "post",
        dataType: "json",
        url: "/landlord/circleList",

        success: function (result) {
            console.log(result);
            var arr = result.data;

            if (arr.length > 0) {
                var outHtml = "";
                var len = arr.length - 1;
                for (var i = 0; i < arr.length; i++) {
                    outHtml += html_1.replace("{userName}", arr[len - i].userName)
                        .replace("{headImg}", arr[len - i].headImg)
                        .replace("{landlordCircleText}", arr[len - i].landlordCircleText)
                        .replace("{landlordCircleImg}", arr[len - i].landlordCircleImg)
                        .replace("{id}", arr[len - i].id);
                }
                $(".landlordCircleMsg").append(outHtml);

            }

        }
    })
}



