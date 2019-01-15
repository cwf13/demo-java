var html_1 = '<span><input width="50px" height="50px"  href="javascript:void(0);" style="color: red" type="button" value="${money}"/></span>';

var html_2 = '<option value="${id}">${title}</option>';

window.onload = function () {
    getStory();
}

function getStory() {


    $.ajax({
        type: "post",
        dataType: "json",
        url: BASE_URL + "/user/denominationList",

        success: function (result) {

            if (result.resCode == 1) {
                var array = result.data.array;
                var HTML_2 = "";
                for (var i = 0; i < array.length; i++) {

                    HTML_2 += html_2.replace("${id}", array[i].id).replace("${title}", array[i].title);

                }

                $("#isproxy").append(HTML_2);
            } else {
                console.log("请重新登陆！");

                location.href = "login.html";

            }
            console.log(result);

        }
    })
}

function getUrlParam() {
    var url = location.host; //获取url中"?"符后的字串
    return url;
}

function getMoney() {
    var id = $("#isproxy").val();
    var type = $("input[type='radio']:checked").val()
    $("#id").val(id);
    $("#type").val(type);
    console.log(type + "uuuuuuuu" + id);
    $("#form1").submit();

}

 var app = angular.module('app',[]);

app.controller('appc',function ($scope,$http) {
    var obj = new Object();
    obj.name = "000000";
    obj.age = "ejjfl";

    $http.post(BASE_URL + "/user/getUserList",obj)
        .then(function (result) {
            alert(result.data.msg);
            alert(result.data.code);

            console.log(result)

            $scope.names = result.data.data.array;
        });

    $scope.delete = function (obj) {
        console.log(obj);
        alert(obj.id);


    }
    $scope.t=false;

    $scope.user = 'John Doe';
    $scope.email = 'john.doe@gmail.com';

    $scope.toggle = function () {

        $scope.t = !$scope.t;

    }
});


