
angular.module('bigCommotion').controller('NewConferenceController', function ($scope, $location, locationParser, ConferenceResource , SessionSubmissionResource, PointOfContactResource, PointOfContactResource) {
    $scope.disabled = false;
    $scope.conference = $scope.conference || {};
    
    $scope.sessionSubmissionsList = SessionSubmissionResource.queryAll(function(items){
        $scope.sessionSubmissionsSelectionList = $.map(items, function(item) {
            return ( {
                value : item,
                text : item.title
            });
        });
    });
    
    $scope.$watch("sessionSubmissionsSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.conference.sessionSubmissions = [];
            $.each(selection, function(idx,selectedItem) {
                $scope.conference.sessionSubmissions.push(selectedItem.value);
            });
        }
    });
    $scope.vendorPointOfContactList = PointOfContactResource.queryAll(function(items){
        $scope.vendorPointOfContactSelectionList = $.map(items, function(item) {
            return ( {
                value : item,
                text : item.fullName
            });
        });
    });
    
    $scope.$watch("vendorPointOfContactSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.conference.vendorPointOfContact = [];
            $.each(selection, function(idx,selectedItem) {
                $scope.conference.vendorPointOfContact.push(selectedItem.value);
            });
        }
    });
    $scope.staffList = PointOfContactResource.queryAll(function(items){
        $scope.staffSelectionList = $.map(items, function(item) {
            return ( {
                value : item,
                text : item.fullName
            });
        });
    });
    
    $scope.$watch("staffSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.conference.staff = [];
            $.each(selection, function(idx,selectedItem) {
                $scope.conference.staff.push(selectedItem.value);
            });
        }
    });

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Conferences/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        ConferenceResource.save($scope.conference, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Conferences");
    };
});