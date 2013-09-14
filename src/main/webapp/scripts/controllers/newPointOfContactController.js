
angular.module('bigCommotion').controller('NewPointOfContactController', function ($scope, $location, locationParser, PointOfContactResource ) {
    $scope.disabled = false;
    $scope.pointOfContact = $scope.pointOfContact || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/PointOfContacts/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        PointOfContactResource.save($scope.pointOfContact, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/PointOfContacts");
    };
});