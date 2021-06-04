'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', function view2Ctrl($scope, $http) {

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
        "faculty": null,
        "institute": null,
        "information": null,
        "votes": 0
      }
    })
  }
});