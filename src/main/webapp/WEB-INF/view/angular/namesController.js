var app = angular.module('myApp4', []);
app.controller('namesCtrl', function($scope) {
    $scope.names = [
        {name:'Jani',country:'Norway'},
        {name:'Hege',country:'Sweden'},
        {name:'Kai',country:'Denmark'}
    ];

    $scope.msg = "chenbin";
});

app.filter('reverse',function(){//可以注入依赖
    return function(text){
        return text.split("").reverse().join("");
    }
});