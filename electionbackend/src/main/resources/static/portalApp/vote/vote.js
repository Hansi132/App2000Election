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
        $scope.voteOnPerson = function (userId) {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/api/v1/castVote',
                data: {
                    "userId": userId,
                    "faculty": null,
                    "institute": null,
                    "information": null,
                    "votes": 0
                }
            }).then(function success(response) {
                console.log("Vote given");
            })
        }
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