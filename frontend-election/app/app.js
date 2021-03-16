'use strict';

// Declare app level module which depends on views, and core components
angular.module('myApp', [
    'ngCookies',
    'ngRoute',
    'myApp.home',
    'myApp.vote',
    'myApp.view1',
    'myApp.view2',
    'myApp.version',
    'myApp.login',
    'element-directives'
]).config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.otherwise({redirectTo: '/home'});
}]);
