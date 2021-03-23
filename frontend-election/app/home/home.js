'use strict';

angular.module('myApp.home', ['ngRoute', 'ngCookies', 'ngSanitize'])

.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'home/home.html',
        controller: 'homeCtrl'
    })
}])

.controller('homeCtrl', function ($scope, $cookies, $sce) {
    $scope.alertBox = "<alert alert-type=\"alert-error\" text=\"Hello world this is an alert\"></alert>"

    $scope.infoScreen = function () {
        return $sce.trustAsHtml($scope.alertBox)
    }
})