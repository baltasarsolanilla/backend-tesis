'use strict'

var demoApp = angular.module('demo', []);

var module = angular.module('demo');

module.controller("UserController", ["$scope",

    function($scope) {
        $scope.helloWorld = 'helloWorld';
	}
]);

var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl: '/views/index.html',
        })
        .otherwise(
            { redirectTo: '/'}
        );
});
