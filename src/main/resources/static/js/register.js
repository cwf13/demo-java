$('#img1').click(function () {
    //#img1为这个img的ID
    var imgurl = $('#img1').attr("src");
    //-1代表没有这东西
    if (imgurl.indexOf("chb_n") > -1) {
        //replace("1","2")2替换1
        $('#img1').attr('src', imgurl.replace("chb_n", "chb_p"));
        $(".btn").css("background-color", "#1f6bd3");
    } else {
        $('#img1').attr('src', imgurl.replace("chb_p", "chb_n"));
        $(".btn").css("background-color", "#d0d0d0")
    }
});

function get() {
    startCountDown(20);
}

$('.btn').click(function () {
    var imgurl = $('#img1').attr("src");
    if (imgurl.indexOf("chb_p") > -1) {
        register();
    } else {
        return;
    }
})


// 注册
function register() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var rePassword = $("#rePassword").val();
    var mobile = $("#phoneNum").val();
    var imageCode = $("#imageCode").val();

    if (userName == "") {
        layer.open({content: "请输入用户名", time: 2, skin: "footer",});
        return;
    } else if (password == "") {
        layer.open({content: "请输入密码", time: 2, skin: "footer",});
        return;
    } else if (rePassword == "") {
        layer.open({content: "请再次输入密码", time: 2, skin: "footer",});
        return;
    } else if (password != rePassword) {
        layer.open({content: "两次密码不一致", time: 2, skin: "footer",});
        return;
    } else if (mobile == "") {
        layer.open({content: "请输入手机号", time: 2, skin: "footer",});
        return;
    } else if (imageCode == "") {
        layer.open({content: "请输入验证码", time: 2, skin: "footer",});
        return;
    }

    var obj = new Object;
    obj.userName = userName;
    obj.password = password;
    obj.mobile = mobile;
    obj.imageCode = imageCode;

    var loading = layer.open({type: 2});
    $.ajax({
        type: "post",
        url: BASE_URL + "/user/register",
        dataType: "json",
        data: obj,

        success: function (result) {
            layer.open(loading);
            console.log(result);
            if (result.resCode == 1) {
                location.href = 'login.html';
            } else {
                layer.open({
                    content: result.resMsg,
                    time: 2,
                    skin: "footer",
                })
            }
        }
    })
}
