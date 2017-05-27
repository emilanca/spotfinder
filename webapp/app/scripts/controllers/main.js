'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('MainCtrl', function ($scope,  $http) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.search_term = "McDonalds";
    $scope.getData = function(search_term) {

      $http.get("http://localhost:8080/places?search_term=" + search_term)
        .then(function(response) {
          $scope.searchResults = response.data;
        });
    }

  });
