// 获取URL的值
function selectData() {
    var loc = location.href;
    var n1 = loc.length;//地址的总长度
    var n2 = loc.indexOf("=");//取得=号的位置
    if (n2 != "-1") {
        // 从index进来清除cookie
        // document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
        document.cookie = "time1=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
        document.cookie = "time2=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
        document.cookie = "num=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
        document.cookie = "location1=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
        var selectData = decodeURI(loc.substr(n2 + 1, n1 - n2));//从=号后面的内容
        var arr = new Array();
        arr = selectData.split("$");
        for (var i = 0; i < arr.length; i++) {
            console.log(arr[i]);
        }

        $("#time").text(arr[0] + "-" + arr[1]);
        $("li").attr("num", arr[2])
        if (arr[3] != "") {
            $("#location").text(arr[3]);
        }
        time1 = arr[0];
        time2 = arr[1];
        numdata = arr[2];
        location1 = arr[3];
    }
}

// 选择排序方式
function px() {
    $(".dropdown-content ").toggle();
    $(".option").click(function () {
        var o = $(this).text();
        $("#px").text(o);
    })
}

// 选择条件
function selectTj() {
    $(".dropdown-content1 ").toggle();
    $(".option1").click(function () {
        var tj = $(this).text();
        $("#tj").text(tj);
    })
}

// cookie 民宿详情返回来条件不变
function setCookie(time1, time11, time2, time22, num, numda, location1, location11, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = time1 + "=" + time11 + ";" + expires;
    document.cookie = time2 + "=" + time22 + ";" + expires;
    document.cookie = num + "=" + numda + ";" + expires;
    document.cookie = location1 + "=" + location11 + ";" + expires;
}

function getCookie(time1, time2, location1, num) {
    var ca = document.cookie.split(';');
    if (ca.length > 1) {
        timeStr1 = ca[0].trim();
        var time1 = getStr(timeStr1);
        console.log(time1);

        timeStr2 = ca[1].trim();
        var time2 = getStr(timeStr2);
        console.log(time2);

        numStr = ca[2].trim();
        var num = getStr(numStr);//从=号后面的内容
        console.log(num);

        numStr = ca[3].trim();
        var location1 = getStr(numStr);//从=号后面的内容
        console.log(location1);
        return time1 + "$" + time2 + "$" + num + "$" + location1;
    }
}

function checkCookie() {
    var loc = getCookie("time1", "time2", "location1", "num");
    if (loc != undefined) {
        var arr = new Array();
        arr = loc.split("$");
        // if (arr[0]!=""){
        // alert("欢迎 " + user + " 再次访问");
        $("#time").text(arr[0] + "-" + arr[1]);
        $("#location").text(arr[3]);
        // }

    } else {
        // if (loc!="" && loc!=null){
        setCookie("time1", time1, "time2", time2, "num", numdata, "location1", location1, 30);
        // }
    }


}

//传startDate，endDate，NumDate的值
$(".listData").on("click", function () {
    var date = $("#time").text();
    var num = $(this).attr("num");
    window.location.href = "homestayDetail.html?" + "t1=" + encodeURI(date) + "$" + encodeURI(num);
    // window.location.href="homestayList.html?"+"t1="+startDate+"-"+endDate+"$"+location;不加encodeURI（）也可以，encodeURI() 函数可把字符串作为 URI 进行编码。

});

function getHomestaylist() {
    $.ajax({
        type: "post",
        dataType: "json",
        url: BASE_URL + "/homestay",

        success: function (result) {
            console.log(result);
        }
    })
}
