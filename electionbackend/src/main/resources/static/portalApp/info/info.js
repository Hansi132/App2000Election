'use strict';

angular.module('myApp.info', ['ngRoute', 'ngCookies', 'ngSanitize'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/info', {
            templateUrl: 'info/info.html',
            controller: 'infoCtrl'
        })
    }])

    .controller('infoCtrl', function ($scope, $cookies, $sce) {
        $scope.closedPopup = function () {
            return $cookies.get("alertPopup");
        }
    })