

angular.module('bigCommotion').controller('EditAssetController', function($scope, $routeParams, $location, AssetResource ) {
    var self = this;
    $scope.disabled = false;

    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.asset = new AssetResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/Assets");
        };
        AssetResource.get({AssetId:$routeParams.AssetId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.asset);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.asset.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Assets");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Assets");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.asset.$remove(successCallback, errorCallback);
    };
    
    $scope.frequencyOfUpdatesList = [
        "UNKNOWN",  
        "LOW",  
        "MED",  
        "HIGH"  
    ];
    
    $scope.get();
});