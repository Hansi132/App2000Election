'use strict';

angular.module('myApp.vote', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/vote', {
            templateUrl: 'vote/vote.html',
            controller: 'VoteCtrl'
        });
    }])

    .controller('VoteCtrl', function VoteCtrl($scope, $http) {
        let items = [];
        $http({
            method: 'GET',
            url: 'http://localhost:8080/api/v1/nominatedPerson',
        }).then(function success(response) {
            $scope.nominatedPersons = response.data;
            $scope.nominatedPersons.forEach(nominee => {
                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/api/v1/user/userId',
                    params: {userId: nominee.userId}
                }).then(function success(response) {
                    items.push(response.data);
                    $scope.nominatedUser = items;
                })
            })
        })
    });