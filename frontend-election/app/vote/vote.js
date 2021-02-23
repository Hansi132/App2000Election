'use strict';

angular.module('myApp.vote', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/vote', {
            templateUrl: 'vote/vote.html',
            controller: 'VoteCtrl'
        });
    }])

    .controller('VoteCtrl', function VoteCtrl($scope, $http) {
        $scope.myNumber = 5;
        $http({
            method: 'GET',
            url: 'http://localhost:8080/api/v1/nominatedPerson'
        }).then(function successCallback(response) {
            $scope.nominatedUsers = response.data;
        });
    });