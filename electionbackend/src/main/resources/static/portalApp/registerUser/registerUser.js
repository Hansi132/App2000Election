'use strict';

angular.module('myApp.registerUser', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/registerUser', {
            templateUrl: 'registerUser/registerUser.html',
            controller: 'registerUserCtrl'
        })
    }])

    .controller('registerUserCtrl', function ($scope) {

    })