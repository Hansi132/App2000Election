'use strict';

angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'home/home.html',
        controller: 'homeCtrl'
    })
}])

.controller('homeCtrl', function ($scope) {
    $scope.gui = {
        "title": "Home",
        "body": "This is the body"
    }
})