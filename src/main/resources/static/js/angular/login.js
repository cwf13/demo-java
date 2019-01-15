var app = angular.module("myApp", []);



app.directive("jj", function() {
    return {
        template : "<h1>自定义fghfdkl指令!</h1>"
    };
});


app.controller('siteCtrl', function($scope, $http,$compile) {
    alert("进来了 siteCtrl");
    var $html = $compile("<button ng-click='myclick()' >点我</button>")($scope);
    $("#logi").append($html);

    $scope.myclick=function(){

        alert("进来了");
        $http({
            method: 'GET',
            url: 'http://rap2api.taobao.org/app/mock/117404/secret/totalPlatformData.html'
        }).then(function successCallback(response) {
            alert( response.data.code);
            alert( response.data.msg);
            alert( response.data.data.totalissueVolumel);

            $scope.names = response.data.sites;
        }, function errorCallback(response) {
            // 请求失败执行代码
        });
    }






});

app.controller('myc',function ($scope) {

    alert("myc");

    $scope.myc=function () {

        alert("点击到了");

    }


})


function myc() {
    alert("jssjss");

}