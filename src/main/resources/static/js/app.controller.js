use strict'

var module = angular.module('demo');

module.controller("UserController", ["$scope",

    function($scope) {

        $scope.helloWorld = 'helloWorld';
	}
]);