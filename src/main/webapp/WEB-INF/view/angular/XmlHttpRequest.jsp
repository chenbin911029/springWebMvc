<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
</head>
<body ng-app="myApp7">

    <div ng-controller="myCtrl">
        <select ng-init="selectedName = namesArray[0]"
                ng-model="selectedName"
                ng-options="c for c in namesArray">
        </select>
        <ul>
            <li ng-repeat = "x in sites">
                {{x.Name + ', ' + x.Country}}
            </li>
        </ul>

        <select ng-model="selectedSite">
            <option ng-repeat="a in sites2" value="{{a.site}}">{{a.site}}</option>
        </select>
        <p>你选择的是：{{selectedSite}}</p>

        <select ng-model="selectedSite2" ng-options="x1.site for x1 in sites2">
        </select>
        <p>你选择的2是：{{selectedSite2.site}}</p>
        <p>网址为: {{selectedSite2.url}}</p>

    </div>
    </div>

    <script>
        var app = angular.module('myApp7',[]);
        app.controller('myCtrl',function($scope,$http){
            $scope.namesArray = ["Google","Runoob","Taobao"];

            $scope.sites2 = [
                {site : "baidu", url : "http://www.google.com"},
                {site : "jingdong", url : "http://www.runoob.com"},
                {site : "alibaba", url : "http://www.taobao.com"}
            ];

            $http({
                method:'GET',
                url:'/test/testJson'
            }).then(function successCallback(response){
                //请求成功执行代码
                $scope.sites = response.data.sites;
            },function errorCallBack(response){
                //请求失败执行代码
                alert(response.data);
            });

        });

    </script>
</body>
</html>








