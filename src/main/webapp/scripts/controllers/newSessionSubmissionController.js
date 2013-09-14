
angular.module('bigCommotion').controller('NewSessionSubmissionController', function ($scope, $location, locationParser, SessionSubmissionResource , ConferenceResource, PresenterResource, PresenterResource, PresenterResource) {
    $scope.disabled = false;
    $scope.sessionSubmission = $scope.sessionSubmission || {};
    
    $scope.conferenceList = ConferenceResource.queryAll(function(items){
        $scope.conferenceSelectionList = $.map(items, function(item) {
            return ( {
                value : item,
                text : item.name
            });
        });
    });
    
    $scope.$watch("conferenceSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.sessionSubmission.conference = selection.value;
        }
    });
    $scope.presenterList = PresenterResource.queryAll(function(items){
        $scope.presenterSelectionList = $.map(items, function(item) {
            return ( {
                value : item,
                text : item.fullName
            });
        });
    });
    
    $scope.$watch("presenterSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.sessionSubmission.presenter = selection.value;
        }
    });
    $scope.coPresenterList = PresenterResource.queryAll(function(items){
        $scope.coPresenterSelectionList = $.map(items, function(item) {
            return ( {
                value : item,
                text : item.fullName
            });
        });
    });
    
    $scope.$watch("coPresenterSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.sessionSubmission.coPresenter = selection.value;
        }
    });
    $scope.thirdPresenterList = PresenterResource.queryAll(function(items){
        $scope.thirdPresenterSelectionList = $.map(items, function(item) {
            return ( {
                value : item,
                text : item.fullName
            });
        });
    });
    
    $scope.$watch("thirdPresenterSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.sessionSubmission.thirdPresenter = selection.value;
        }
    });

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/SessionSubmissions/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        SessionSubmissionResource.save($scope.sessionSubmission, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/SessionSubmissions");
    };
});