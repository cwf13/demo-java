// 获取好友列表
var html_1 = '<li class="clearfix" onclick="window.location.href=\'chatDetail.html?friendId={id}&&headImg={headImg}\'">\
               <img src={headImg} alt="">\
              <span>{userName}</span>\
             </li>'

function friendsList() {
    $.ajax({
        type: "post",
        dataType: "json",
        url: "/chat/list",

        success: function (result) {
            console.log(result);
            if (result.resCode == 1) {
                var outHtml = "";
                for (var i = 0; i < result.data.length; i++) {
                    outHtml += html_1.replace("{userName}", result.data[i].userName)
                        .replace("{headImg}", result.data[i].headImg)
                        .replace("{id}", result.data[i].id)
                        .replace("{headImg}", result.data[i].headImg)
                }
                $(".friendsList").append(outHtml);
            }

        }
    })
}