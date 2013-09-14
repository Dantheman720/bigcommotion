

angular.module('bigCommotion').controller('EditPointOfContactController', function($scope, $routeParams, $location, PointOfContactResource ) {
    var self = this;
    $scope.disabled = false;

    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.pointOfContact = new PointOfContactResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/PointOfContacts");
        };
        PointOfContactResource.get({PointOfContactId:$routeParams.PointOfContactId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.pointOfContact);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.pointOfContact.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/PointOfContacts");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/PointOfContacts");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.pointOfContact.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});