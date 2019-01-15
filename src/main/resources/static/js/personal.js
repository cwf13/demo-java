// 获取个人信息
function getPersonal() {
    $.ajax({
        type: "post",
        dataType: "json",
        url: BASE_URL + "/user/info",

        success: function (result) {
            console.log(result);
            $("#nick").text(result.data.userName);
            $(".d-head").attr("src", result.data.headImg);
        }
    })
}