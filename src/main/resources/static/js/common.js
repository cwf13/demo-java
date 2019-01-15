var BASE_PATH = "http://localhost:80";
var BASE_URL = BASE_PATH;
var BASE_WEB_PATH = BASE_PATH;
var BASE_WEB_IMG = BASE_PATH;
var TOPCOLOR = "#1f2033";
var APPDOWNLOAD = "https://fir.im/gkzl";
var version = "v.2018.10.10";
//分隔符
var SEPARATOR = "x@y&r";

//开始短信获取倒计时
function startCountDown(time) {
    timer_nowtime = time;
    var timer_target = null;
    if (timer_target) clearTimeout(timer_target);

    if (time > 0) {
        time--;
        $(".btn-getverify").text("等待" + time + "s");
        timer_target = setTimeout(function () {
            startCountDown(time)
        }, 1000)
    } else {
        if (timer_target) clearTimeout(timer_target);
        $(".btn-getverify").text("获取验证码");
    }
}

// 取=后的字符串
function getStr(str) {
    var n1 = str.length;//地址的总长度
    var n2 = str.indexOf("=");//取得=号的位置
    var strData = str.substr(n2 + 1, n1 - n2);//从=号后面的内容
    return strData;
}

//通过参数名获取参数值
function getSearch(name) {
    var search = (window.location.search || '').replace(/^\?/, '&');
    var Regx = new RegExp('&' + name + '=([^&$]+)(&|$)');
    var res = Regx.exec(search);
    return (res && res.length) ? res[1] : null;
}