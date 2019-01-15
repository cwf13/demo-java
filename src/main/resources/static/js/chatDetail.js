function fs() {
    var txt = $(".in").html();
    if (txt != "") {
        // $(".main").append('<div class="qp clearfix"><img src="../../static/img/common/touxiang.png"><div class="msg">'+txt+'</div></div><br/>');
        addInfo1(txt);
        $(".in").html("");
        //测用 暂时不封装，具体使用时需要封装，和后端约定参数和具体封装方式
        send(txt);
    }
}

var userId = 0;

var friendId = getSearch("friendId");

// 从列表获取好友的头像
var friendIdImg = getSearch("headImg");
var webSocketUrl = "ws://localhost:80/webSocket";
var headImg = "";

function getId() {
    $.ajax({
        type: "post",
        url: "/user/info",
        dataType: "json",
        success: function (result) {
            console.log(result);
            if (result.resCode == 1) {
                userId = result.data.id;
                headImg = result.data.headImg;
                wscreate();
            } else {
            }
        }

    });
}

getId();

function bl() {
    $("#emoji_list").toggle();
}

// 发送人自己的信息
function addInfo1(txt) {
    $(".main").append('<div class="qp clearfix"><img src=' + headImg + ' class="img1"><div class="msg1">' + txt + '</div></div><br/>');
}

// 接收的信息
function addInfo2(txt) {
    $(".main").append('<div class="qp clearfix"><img src=' + friendIdImg + ' class="img2"><div class="msg2">' + txt + '</div></div><br/>');
}

//websocket 相关
var websocket = null;

//创建连接
function wscreate() {
    //判断当前浏览器是否支持WebSocket 地址如果部署到服务器 需要写服务器的地址
    if ('WebSocket' in window) {

        websocket = new WebSocket(webSocketUrl);
    }
    else {
        alert('Not support websocket')
    }
    websocket.onerror = function () {
        addInfo1("error");
    };

//连接成功建立的回调方法
    websocket.onopen = function (event) {
        // addInfo1("begin");
        websocket.send('joinId' + '=' + userId + SEPARATOR +
            'friendId' + '=' + friendId);
    };

//接收到消息的回调方法
    websocket.onmessage = function (event) {
        var res = event.data.split(SEPARATOR);
        for (var i = 0; i < res.length; i++) {
            addInfo2(res[i]);
        }
    };

//连接关闭的回调方法
    websocket.onclose = function () {
        // setMessageInnerHTML("end");
    };

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        out();
        websocket.close();
    };
}

//连接发生错误的回调方法


//将消息显示在网页上
// function setMessageInnerHTML(innerHTML) {
//     document.getElementById('message').innerHTML += innerHTML + '<br/>';
// }

//关闭连接
function closeWebSocket() {
    out();
    websocket.close();
}

//发送消息
function send(info) {
    var message = 'userId=' + userId + SEPARATOR +
        'friendId=' + friendId + SEPARATOR +
        'info=' + info;
    websocket.send(message);
}

function out() {
    websocket.send('outId' + '=' + userId + SEPARATOR +
        'friendId' + '=' + friendId);
}


//选择图片上传
$('.select').click(function () {
    imgtishi();
});


// 图片上传
function imgtishi() {
    layer.open({
        content: '<p class="p-file">文件夹</p>' + '<p class="p-camera">照相</p>'
        , btn: ['取消']
        , skin: 'footer'
        , className: "pop-up-footer-cho"
        , yes: function (index) {
            layer.close(index);
        }
        , success: function () {
            $(".p-camera").on("click", function () {
                HEADSETING.callCarmera('1,backFun');
            });
            $(".p-file").on("click", function () {
                $(".up_file").click();
            });
        }
    });
}


// 图片上传
$("body").on("change", ".up_file", function () {

    var imagSize = this.files[0].size;
    if (imagSize > 1024 * 1024 * 5) {
        layer.closeAll("loading");
        layer.msg("图片大小在5M以内");
        return;
    }
    layer.open({type: 2});
    var formData = new FormData();

    formData.append("type", "0");
    formData.append('file', $('#file1')[0].files[0]);
    $.ajax({
        "cache": false,
        "processData": false,
        "contentType": false,
        "type": "POST",
        "url": BASE_URL + "/imgupload.html",
        "data": formData,
        "dataType": "json",
        "success": function (result) {
            console.log("[图片 result]：" + JSON.stringify(result));
            if (result.data.path) {
                $("#img_url").val(result.data.path);
                $(".frame img").attr("src", BASE_WEB_IMG + result.data.path);
                saveImage();
            } else {
                layer.open({content: result.msg, skin: 'msg', time: 2});
            }
            setTimeout(function () {
                layer.closeAll("loading");
            }, 1000);

        },
        "error": function (xhr, errorText, erroType) {//xhr:XMLHttpRequest对象  errorText:错误信息  erroType：（可选）捕获的异常对象
            console.log("ajax错误类型：" + erroType);
            console.log("ajax错误信息：" + errorText);
            layer.closeAll();
            layer.open({
                content: "请求失败，请检查网络状况",
                skin: 'footer',
                className: "pop-up-footer"
            });
        }
    });
});

