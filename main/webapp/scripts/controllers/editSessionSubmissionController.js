

angular.module('bigCommotion').controller('EditSessionSubmissionController', function($scope, $routeParams, $location, SessionSubmissionResource , ConferenceResource, PresenterResource, PresenterResource, PresenterResource) {
    var self = this;
    $scope.disabled = false;

    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.sessionSubmission = new SessionSubmissionResource(self.original);
            ConferenceResource.queryAll(function(items) {
                $scope.conferenceSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        value : item,
                        text : item.name
                    };
                    if($scope.sessionSubmission.conference && item.id == $scope.sessionSubmission.conference.id) {
                        $scope.conferenceSelection = wrappedObject;
                    }
                    return wrappedObject;
                });
            });
            PresenterResource.queryAll(function(items) {
                $scope.presenterSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        value : item,
                        text : item.fullName
                    };
                    if($scope.sessionSubmission.presenter && item.id == $scope.sessionSubmission.presenter.id) {
                        $scope.presenterSelection = wrappedObject;
                    }
                    return wrappedObject;
                });
            });
            PresenterResource.queryAll(function(items) {
                $scope.coPresenterSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        value : item,
                        text : item.fullName
                    };
                    if($scope.sessionSubmission.coPresenter && item.id == $scope.sessionSubmission.coPresenter.id) {
                        $scope.coPresenterSelection = wrappedObject;
                    }
                    return wrappedObject;
                });
            });
            PresenterResource.queryAll(function(items) {
                $scope.thirdPresenterSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        value : item,
                        text : item.fullName
                    };
                    if($scope.sessionSubmission.thirdPresenter && item.id == $scope.sessionSubmission.thirdPresenter.id) {
                        $scope.thirdPresenterSelection = wrappedObject;
                    }
                    return wrappedObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/SessionSubmissions");
        };
        SessionSubmissionResource.get({SessionSubmissionId:$routeParams.SessionSubmissionId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.sessionSubmission);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.sessionSubmission.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/SessionSubmissions");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/SessionSubmissions");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.sessionSubmission.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("conferenceSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sessionSubmission.conference = selection.value;
        }
    });
    $scope.$watch("presenterSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sessionSubmission.presenter = selection.value;
        }
    });
    $scope.$watch("coPresenterSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sessionSubmission.coPresenter = selection.value;
        }
    });
    $scope.$watch("thirdPresenterSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sessionSubmission.thirdPresenter = selection.value;
        }
    });
    
    $scope.get();
});