'use strict';

angular.module('myApp.vote', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/vote', {
            templateUrl: 'vote/vote.html',
            controller: 'VoteCtrl'
        });
    }])

    .controller('VoteCtrl', function VoteCtrl($scope, $http) {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/api/v1/user'
        }).then(function successCallback(response) {
            $scope.users = response.data;
        });

        $scope.nominatePerson = function (id) {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/api/v1/nominatedPerson',
                data: {
                    "userId": id,
                    "faculty": "IT",
                    "institute": "IT",
                    "information": "Jeg elsker it",
                    "votes": 0,
                    "pictureId": 1
                }
            })
        }
    });