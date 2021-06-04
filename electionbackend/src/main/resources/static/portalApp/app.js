'use strict';

// Declare app level module which depends on views, and core components
angular.module('myApp', [
    'element-directives',
    'ngSanitize',
    'ngCookies',
    'ngRoute',
    'myApp.home',
    'myApp.vote',
    'myApp.view1',
    'myApp.view2',
    'myApp.version',
    'myApp.login',
    'myApp.registerUser',
]).config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.otherwise({redirectTo: '/home'});
}]).controller('appController', function appController($scope, $http, $rootScope) {
    //This is the controller for the entire system. For global actions across all pages use this

    $scope.isUserNominated = function (userId) {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/api/v1/nominatedPerson'
        }).then(function successCallback(response) {
            $scope.nominatedUsers = response.data;
            $scope.nominatedUsers.some(user => {
                if (user.userId === userId) {
                    return true;
                }
            })
        });
    }

    $http({
        method: 'GET',
        url: 'http://localhost:8080/api/v1/userInfo'
    }).then(function successCallback(response) {
        $rootScope.user = response.data;
        $http({
            method: 'GET',
            url: 'http://localhost:8080/api/v1/user/email',
            params: {email: $rootScope.user.email}
        }).then(function success(response) {
            $rootScope.user = response.data;
            $http({
                method: 'GET',
                url: 'http://localhost:8080/api/v1/user/userType',
                params: {userId: $rootScope.user.id}
            }).then(function success(response) {
                $rootScope.user.userType = response.data;
                $rootScope.user.isNominated = $scope.isUserNominated($rootScope.user.id);
                $rootScope.top5 = [];
                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/api/v1/nominatedPerson/top5'
                }).then(function success(response) {
                    response.data.forEach(item => {
                        $http({
                            method: 'GET',
                            url: 'http://localhost:8080/api/v1/user/userId',
                            params: {userId: item.userId}
                        }).then(function success(response) {
                            $rootScope.top5.push(response.data);
                        })
                    });
                })
            })
        })
    });
}).run( function($rootScope, $location) {

})
