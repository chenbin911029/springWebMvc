var app = angular.module('myApp9',[]);
app.controller('myCtrl',function($scope){
    $scope.count = 0;
    $scope.firstName = 'John';
    $scope.lastName = 'Doe';
    $scope.text = '点击消失';

    $scope.myVar = false;
    $scope.toggle = function(){
        $scope.myVar = !$scope.myVar;
        $scope.text = $scope.myVar ? '点击可见' : '点击消失';
    }

    $scope.master = {firstName: "John", lastName: "Doe"};
    $scope.reset = function(){
      $scope.user = angular.copy($scope.master);
    };
    $scope.reset();
});

//自定义指令
app.directive('selfDirective2',function(){
    return {
        template:"自定义指令"
    };
});

