

angular.module('bigCommotion').controller('SearchSessionSubmissionController', function($scope, $http, SessionSubmissionResource , ConferenceResource, PresenterResource, PresenterResource, PresenterResource) {

    $scope.search={};
    $scope.currentPage = 0;
    $scope.pageSize= 10;
    $scope.searchResults = [];
    $scope.filteredResults = [];
    $scope.pageRange = [];
    $scope.numberOfPages = function() {
        var result = Math.ceil($scope.filteredResults.length/$scope.pageSize);
        var max = (result == 0) ? 1 : result;
        $scope.pageRange = [];
        for(var ctr=0;ctr<max;ctr++) {
            $scope.pageRange.push(ctr);
        }
        return max;
    };
    $scope.conferenceList = ConferenceResource.queryAll();
    $scope.presenterList = PresenterResource.queryAll();
    $scope.coPresenterList = PresenterResource.queryAll();
    $scope.thirdPresenterList = PresenterResource.queryAll();

    $scope.performSearch = function() {
        $scope.searchResults = SessionSubmissionResource.queryAll(function(){
            $scope.numberOfPages();
        });
    };
    
    $scope.previous = function() {
       if($scope.currentPage > 0) {
           $scope.currentPage--;
       }
    };
    
    $scope.next = function() {
       if($scope.currentPage < ($scope.numberOfPages() - 1) ) {
           $scope.currentPage++;
       }
    };
    
    $scope.setPage = function(n) {
       $scope.currentPage = n;
    };

    $scope.performSearch();
});