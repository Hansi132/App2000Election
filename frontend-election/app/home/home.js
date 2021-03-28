'use strict';

angular.module('myApp.home', ['ngRoute', 'ngCookies', 'ngSanitize'])

.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'home/home.html',
        controller: 'homeCtrl'
    })
}])

.controller('homeCtrl', function ($scope, $cookies, $sce) {
     $scope.closedPopup = function () {
         return $cookies.get("alertPopup");
     }
})