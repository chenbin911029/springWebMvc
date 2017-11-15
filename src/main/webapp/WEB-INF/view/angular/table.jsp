<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="https://cdn.bootcss.com/angular.js/1.6.3/angular.min.js"></script>
</head>
<body>

<div ng-app="myApp8" ng-controller="customersCtrl">

    <table>
        <tr ng-repeat="x in names">
            <td>{{ $index + 1 }}</td>
            <td ng-if="$odd" style="background-color:#f1f1f1">{{ x.Name }}</td>
            <td ng-if="$even">{{x.Name}}</td>
            <td ng-if="$odd" style="background-color:#f1f1f1">{{ x.Country }}</td>
            <td ng-if="$even">{{x.Country}}</td>
        </tr>
    </table>

</div>

<script>
    var app = angular.module('myApp8', []);
    app.controller('customersCtrl', function($scope, $http) {
        $http.get("/angular/tableJson")
            .then(function (result) {
                $scope.names = result.data.records;
            });
    });
</script>

</body>
</html>