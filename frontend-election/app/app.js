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
}]).controller('appController', function appController($scope) {
    //This is the controller for the entire system. For global actions across all pages use this

}).run( function($rootScope, $location) {

})
