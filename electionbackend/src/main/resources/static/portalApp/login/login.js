'use strict';

angular.module('myApp.login', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'login/login.html',
            controller: 'loginCtrl'
        });
    }])

    .controller('loginCtrl', function loginCtrl($scope, $http){
        $scope.userEmail = null;
        $scope.userPassword = null;


        function checkValidEmail(userEmail) {

        }

        function checkValidPassword(userPassword) {
            return false;
        }

        $scope.login = function () {
            if (checkValidEmail($scope.userEmail) && checkValidPassword($scope.userPassword)) {

            } else {
                return $scope.showErrorPopup = true;
            }
        }


    });