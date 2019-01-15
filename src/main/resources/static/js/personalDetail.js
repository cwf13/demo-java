function getPersonal() {
    $.ajax({
        type: "post",
        dataType: "json",
        url: BASE_URL + "/user/info",

        success: function (result) {
            console.log(result);
            $("#nick").text(result.data.userName);
            $("#nick1").text(result.data.userName);
            $("#mobileNum").text(result.data.mobile);
            $(".tx").attr("src", result.data.headImg);
        }
    })
}