'use strict';

angular.module('bigCommotion',['ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/Assets',{templateUrl:'views/Asset/search.html',controller:'SearchAssetController'})
      .when('/Assets/new',{templateUrl:'views/Asset/detail.html',controller:'NewAssetController'})
      .when('/Assets/edit/:AssetId',{templateUrl:'views/Asset/detail.html',controller:'EditAssetController'})
      .when('/Conferences',{templateUrl:'views/Conference/search.html',controller:'SearchConferenceController'})
      .when('/Conferences/new',{templateUrl:'views/Conference/detail.html',controller:'NewConferenceController'})
      .when('/Conferences/edit/:ConferenceId',{templateUrl:'views/Conference/detail.html',controller:'EditConferenceController'})
      .when('/PointOfContacts',{templateUrl:'views/PointOfContact/search.html',controller:'SearchPointOfContactController'})
      .when('/PointOfContacts/new',{templateUrl:'views/PointOfContact/detail.html',controller:'NewPointOfContactController'})
      .when('/PointOfContacts/edit/:PointOfContactId',{templateUrl:'views/PointOfContact/detail.html',controller:'EditPointOfContactController'})
      .when('/Presenters',{templateUrl:'views/Presenter/search.html',controller:'SearchPresenterController'})
      .when('/Presenters/new',{templateUrl:'views/Presenter/detail.html',controller:'NewPresenterController'})
      .when('/Presenters/edit/:PresenterId',{templateUrl:'views/Presenter/detail.html',controller:'EditPresenterController'})
      .when('/SessionSubmissions',{templateUrl:'views/SessionSubmission/search.html',controller:'SearchSessionSubmissionController'})
      .when('/SessionSubmissions/new',{templateUrl:'views/SessionSubmission/detail.html',controller:'NewSessionSubmissionController'})
      .when('/SessionSubmissions/edit/:SessionSubmissionId',{templateUrl:'views/SessionSubmission/detail.html',controller:'EditSessionSubmissionController'})
      .when('/UserGroups',{templateUrl:'views/UserGroup/search.html',controller:'SearchUserGroupController'})
      .when('/UserGroups/new',{templateUrl:'views/UserGroup/detail.html',controller:'NewUserGroupController'})
      .when('/UserGroups/edit/:UserGroupId',{templateUrl:'views/UserGroup/detail.html',controller:'EditUserGroupController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
