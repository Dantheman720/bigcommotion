

angular.module('bigCommotion').controller('EditPresenterController', function($scope, $routeParams, $location, PresenterResource ) {
    var self = this;
    $scope.disabled = false;

    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.presenter = new PresenterResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/Presenters");
        };
        PresenterResource.get({PresenterId:$routeParams.PresenterId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.presenter);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.presenter.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Presenters");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Presenters");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.presenter.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});