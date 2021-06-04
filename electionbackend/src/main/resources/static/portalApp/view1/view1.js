'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', function View1Ctrl($scope, $http) {
  $scope.myNumber = 5;

  $scope.withdrawFromElection = function (userId) {
    $http({
      method: 'POST',
      url: 'http://localhost:8080/api/v1/nominatedPerson/withdraw',
      params: {userId: userId}
    })
  }

  $scope.createNewElection = function () {
    let dateStart = new Date().getTime();
    let dateEnd = new Date().getTime();
    dateEnd = dateEnd + 2592000000;
    $http({
      method: 'POST',
      url: 'http://localhost:8080/api/v1/election',
      data: {
        "electionId": 0,
        "electionStart": dateStart,
        "electionEnd": dateEnd,
        "controlled": false,
        "electedUserId": null
      }
    })
  }

});