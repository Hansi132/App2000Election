'use strict';

angular.module('myApp.registerUser', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/registerUser', {
            templateUrl: 'registerUser/registerUser.html',
            controller: 'registerUserCtrl'
        })
    }])

    .controller('registerUserCtrl', function ($scope, $http) {
        $scope.firstPassword = null;
        $scope.secondPassword = null;

        $scope.gui = {
            email: null,
            fname: null,
            lname:  null,
            password: null,
            fDate:  null,
            gender:  null,
        }

        function checkValidEmail(userEmail) {
            if (userEmail.indexOf("@usn.no") === -1) {
                return false;
            } else {
                return true;
            }
        }

        $scope.checkValidPassword = function(firstPassword, secondPassword) {
            if (firstPassword === secondPassword) {
                $scope.gui.password = firstPassword;
                return true;
            } else {
                return false;
            }
        }

        $scope.registerUser = function () {
            if (checkValidEmail($scope.gui.email) && $scope.checkValidPassword($scope.firstPassword, $scope.secondPassword)) {
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/api/v1/user',
                    data: $scope.gui,
                }).then(function success() {
                    //TODO Route the user to their homepage.
                }, function error() {
                    //TODO Handle the error if there is any.
                })
            } else {
                return $scope.showErrorPopup = true;
            }
        }
    })