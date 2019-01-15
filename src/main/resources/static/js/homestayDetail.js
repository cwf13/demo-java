// 轮播图start
jQuery(document).ready(function ($) {

    var jssor_1_SlideshowTransitions = [
        {
            $Duration: 1200,
            x: 0.3,
            $During: {$Left: [0.3, 0.7]},
            $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: -0.3,
            $SlideOut: true,
            $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: -0.3,
            $During: {$Left: [0.3, 0.7]},
            $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: 0.3,
            $SlideOut: true,
            $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            y: 0.3,
            $During: {$Top: [0.3, 0.7]},
            $Easing: {$Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            y: -0.3,
            $SlideOut: true,
            $Easing: {$Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            y: -0.3,
            $During: {$Top: [0.3, 0.7]},
            $Easing: {$Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            y: 0.3,
            $SlideOut: true,
            $Easing: {$Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: 0.3,
            $Cols: 2,
            $During: {$Left: [0.3, 0.7]},
            $ChessMode: {$Column: 3},
            $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: 0.3,
            $Cols: 2,
            $SlideOut: true,
            $ChessMode: {$Column: 3},
            $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            y: 0.3,
            $Rows: 2,
            $During: {$Top: [0.3, 0.7]},
            $ChessMode: {$Row: 12},
            $Easing: {$Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            y: 0.3,
            $Rows: 2,
            $SlideOut: true,
            $ChessMode: {$Row: 12},
            $Easing: {$Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            y: 0.3,
            $Cols: 2,
            $During: {$Top: [0.3, 0.7]},
            $ChessMode: {$Column: 12},
            $Easing: {$Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            y: -0.3,
            $Cols: 2,
            $SlideOut: true,
            $ChessMode: {$Column: 12},
            $Easing: {$Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: 0.3,
            $Rows: 2,
            $During: {$Left: [0.3, 0.7]},
            $ChessMode: {$Row: 3},
            $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: -0.3,
            $Rows: 2,
            $SlideOut: true,
            $ChessMode: {$Row: 3},
            $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: 0.3,
            y: 0.3,
            $Cols: 2,
            $Rows: 2,
            $During: {$Left: [0.3, 0.7], $Top: [0.3, 0.7]},
            $ChessMode: {$Column: 3, $Row: 12},
            $Easing: {$Left: $Jease$.$InCubic, $Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            x: 0.3,
            y: 0.3,
            $Cols: 2,
            $Rows: 2,
            $During: {$Left: [0.3, 0.7], $Top: [0.3, 0.7]},
            $SlideOut: true,
            $ChessMode: {$Column: 3, $Row: 12},
            $Easing: {$Left: $Jease$.$InCubic, $Top: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            $Delay: 20,
            $Clip: 3,
            $Assembly: 260,
            $Easing: {$Clip: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            $Delay: 20,
            $Clip: 3,
            $SlideOut: true,
            $Assembly: 260,
            $Easing: {$Clip: $Jease$.$OutCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            $Delay: 20,
            $Clip: 12,
            $Assembly: 260,
            $Easing: {$Clip: $Jease$.$InCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        },
        {
            $Duration: 1200,
            $Delay: 20,
            $Clip: 12,
            $SlideOut: true,
            $Assembly: 260,
            $Easing: {$Clip: $Jease$.$OutCubic, $Opacity: $Jease$.$Linear},
            $Opacity: 2
        }
    ];

    var jssor_1_options = {
        $AutoPlay: true,
        $SlideshowOptions: {
            $Class: $JssorSlideshowRunner$,
            $Transitions: jssor_1_SlideshowTransitions,
            $TransitionsOrder: 1
        },
        $ArrowNavigatorOptions: {
            $Class: $JssorArrowNavigator$
        },
        $ThumbnailNavigatorOptions: {
            $Class: $JssorThumbnailNavigator$,
            $Cols: 10,
            $SpacingX: 8,
            $SpacingY: 8,
            $Align: 360
        }
    };

    var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

    //responsive code begin
    //you can remove responsive code if you don't want the slider scales while window resizing
    function ScaleSlider() {
        var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
        if (refSize) {
            refSize = Math.min(refSize, 800);
            jssor_1_slider.$ScaleWidth(refSize);
        }
        else {
            window.setTimeout(ScaleSlider, 30);
        }
    }

    ScaleSlider();
    $(window).bind("load", ScaleSlider);
    $(window).bind("resize", ScaleSlider);
    $(window).bind("orientationchange", ScaleSlider);
    //responsive code end
});
// 轮播图结束

// 从cookie中获取startDate，endDate，num的值
function getcookie() {
    var ca = document.cookie.split(';');
    var startDate = ca[0].trim();
    var startDate1 = getStr(startDate);

    var endDate = ca[1].trim();
    var endDate1 = getStr(endDate);

    var data = startDate1 + "-" + endDate1;
    $(".data").text(data);

    var NumDate = ca[2].trim();
    NumDate1 = getStr(NumDate);
    $(".num").text(NumDate1);
}

//百度地图标注
var map = new BMap.Map("allmap");
map.centerAndZoom(new BMap.Point(118.5958490734, 24.9203603836), 30);
map.enableScrollWheelZoom(true);

// 获取用户userId
function getId() {
    $.ajax({
        type: "post",
        url: "/user/info",
        dataType: "json",
        success: function (result) {
            console.log(result);
            if (result.resCode == 1) {
                userId = result.data.id;
                console.log(userId);
            } else {
            }
        }

    });
}


// 添加朋友
function addFriend() {
    var friendId = 2;

    var obj = new Object();
    obj.userId = userId;
    obj.friendId = friendId;

    $.ajax({
        type: "post",
        url: "/chat/addFriend",
        data: obj,
        dataType: "json",


        success: function (result) {
            console.log(result);
            localhost.href = 'chatDetail.html';
        }
    })
}