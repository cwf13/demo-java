// 手机号登录
function phoneLogin() {
    $(".telLogin,.yzm").hide();
    $(".user,.passWord").show();
    $(".t1").removeClass("borderColor");
    $(".u1").addClass("borderColor");
}

// 用户名登录
function userNameLogin() {
    $(".user,.passWord").hide();
    $(".telLogin,.yzm").show();
    $(".t1").addClass("borderColor");
    $(".u1").removeClass("borderColor");
}

// 获取验证码
function getCode() {
    startCountDown(20);
}

// 登录请求
function login() {
    var userNameLogin = $(".userNameLogin").val();
    var pass = $(".pass").val();

    if (userNameLogin == "" || userNameLogin == null) {
        layer.open({content: "用户名不正确", skin: 'footer', time: 1,});
        return;
    } else if (pass == "") {
        layer.open({content: "密码为空", skin: 'footer', time: 1,});
        return;
    }

    var obj = new Object();
    obj.userName = userNameLogin;
    obj.password = pass;

    var loading = layer.open({type: 2});
    $.ajax({
        type: "post",
        url: BASE_URL + "/user/zalogin",
        dataType: "json",
        data: obj,

        success: function (result) {
            layer.close(loading);
            console.log(result);
            if (result.resCode == 1) {
                location.href = 'zaindex.html';
            } else {
                layer.open({
                    content: result.resMsg,
                    skin: 'footer',
                    time: 1, //1s后自动关闭
                });
            }
        }

    });

}