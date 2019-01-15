// 选择日期
function selectData() {
    $('#firstSelect').on('click', function () {
        $('.mask_calendar').show();
    });
    $('.mask_calendar').on('click', function (e) {
        if (e.target.className == "mask_calendar") {
            $('.calendar').slideUp(200);
            $('.mask_calendar').fadeOut(200);
        }
    })
    $('#firstSelect').calendarSwitch({
        selectors: {
            sections: ".calendar"
        },
        index: 4,      //展示的月份个数
        animateFunction: "slideToggle",        //动画效果
        controlDay: true,//知否控制在daysnumber天之内，这个数值的设置前提是总显示天数大于90天
        daysnumber: "90",     //控制天数
        comeColor: "#1b8cf4",       //入住颜色
        outColor: "#1b8cf4",      //离店颜色
        comeoutColor: "#E0F4F2",        //入住和离店之间的颜色
        callback: function () {//回调函数
            $('.mask_calendar').fadeOut(200);
            var startDate = $('#startDate').val();  //入住的天数
            var endDate = $('#endDate').val();      //离店的天数
            var NumDate = $('.NumDate').text();    //共多少晚
            console.log(startDate);
            console.log(endDate);
            console.log(NumDate);
            //下面做ajax请求
            //show_loading();
            /*$.post("demo.php",{startDate:startDate, endDate:endDate, NumDate:NumDate},function(data){
                if(data.result==1){
                    //成功
                } else {
                    //失败
                }
            });*/
        },
        comfireBtn: '.comfire'//确定按钮的class或者id
    });

    var b = new Date();
    var ye = b.getFullYear();
    var mo = b.getMonth() + 1;
    mo = mo < 10 ? "0" + mo : mo;
    var da = b.getDate();
    da = da < 10 ? "0" + da : da;
    $('#startDate').val(ye + '.' + mo + '.' + da);
    b = new Date(b.getTime() + 24 * 3600 * 1000);
    var ye = b.getFullYear();
    var mo = b.getMonth() + 1;
    mo = mo < 10 ? "0" + mo : mo;
    var da = b.getDate();
    da = da < 10 ? "0" + da : da;
    $('#endDate').val(ye + '.' + mo + '.' + da);
};

// 从cookie中获取startDate，endDate，num的值
function re() {
    var ca = document.cookie.split(';');
    if (ca[0] != "") {
        var startDate = ca[0].trim();
        var startDate1 = getStr(startDate);
        $("#startDate").val(startDate1);

        var endDate = ca[1].trim();
        var endDate1 = getStr(endDate);
        $("#endDate").val(endDate1);

        var NumDate = ca[2].trim();
        var NumDate1 = getStr(NumDate);
        $(".NumDate").text(NumDate1);
    }
}

function onAdd() {
    var value1 = $(".num").val();
    var v1 = parseInt(value1) + 1;
    $(".num").val(v1);
}

function onSub() {
    var value1 = $(".num").val();
    if (value1 >= 2) {
        var v2 = parseInt(value1) - 1;
        $(".num").val(v2);
    } else {
        $(".num").val(1);
    }
}

function peopleAdd() {
    var value1 = $(".peopleNum").val();
    var v1 = parseInt(value1) + 1;
    $(".peopleNum").val(v1);
}

function peopleSub() {
    var value1 = $(".peopleNum").val();
    if (value1 >= 2) {
        var v2 = parseInt(value1) - 1;
        $(".peopleNum").val(v2);
    } else {
        $(".peopleNum").val(1);
    }
}