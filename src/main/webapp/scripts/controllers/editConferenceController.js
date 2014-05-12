

angular.module('bigCommotion').controller('EditConferenceController', function($scope, $routeParams, $location, ConferenceResource , SessionSubmissionResource, PointOfContactResource, PointOfContactResource) {
    var self = this;
    $scope.disabled = false;

    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.conference = new ConferenceResource(self.original);
            SessionSubmissionResource.queryAll(function(items) {
                $scope.sessionSubmissionsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        value : item,
                        text : item.title
                    };
                    if($scope.conference.sessionSubmissions){
                        $.each($scope.conference.sessionSubmissions, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sessionSubmissionsSelection.push(wrappedObject);
                            }
                        });
                    }
                    return wrappedObject;
                });
            });
            PointOfContactResource.queryAll(function(items) {
                $scope.vendorPointOfContactSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        value : item,
                        text : item.fullName
                    };
                    if($scope.conference.vendorPointOfContact){
                        $.each($scope.conference.vendorPointOfContact, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.vendorPointOfContactSelection.push(wrappedObject);
                            }
                        });
                    }
                    return wrappedObject;
                });
            });
            PointOfContactResource.queryAll(function(items) {
                $scope.staffSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        value : item,
                        text : item.fullName
                    };
                    if($scope.conference.staff){
                        $.each($scope.conference.staff, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.staffSelection.push(wrappedObject);
                            }
                        });
                    }
                    return wrappedObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Conferences");
        };
        ConferenceResource.get({ConferenceId:$routeParams.ConferenceId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.conference);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.conference.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Conferences");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Conferences");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.conference.$remove(successCallback, errorCallback);
    };
    
    $scope.sessionSubmissionsSelection = $scope.sessionSubmissionsSelection || [];
    $scope.$watch("sessionSubmissionsSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.conference) {
            $scope.conference.sessionSubmissions = [];
            $.each(selection, function(idx,selectedItem) {
                $scope.conference.sessionSubmissions.push(selectedItem.value);
            });
        }
    });
    $scope.vendorPointOfContactSelection = $scope.vendorPointOfContactSelection || [];
    $scope.$watch("vendorPointOfContactSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.conference) {
            $scope.conference.vendorPointOfContact = [];
            $.each(selection, function(idx,selectedItem) {
                $scope.conference.vendorPointOfContact.push(selectedItem.value);
            });
        }
    });
    $scope.staffSelection = $scope.staffSelection || [];
    $scope.$watch("staffSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.conference) {
            $scope.conference.staff = [];
            $.each(selection, function(idx,selectedItem) {
                $scope.conference.staff.push(selectedItem.value);
            });
        }
    });
    
    $scope.get();
});