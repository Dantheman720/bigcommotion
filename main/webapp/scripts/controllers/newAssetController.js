
angular.module('bigCommotion').controller('NewAssetController', function ($scope, $location, locationParser, AssetResource ) {
    $scope.disabled = false;
    $scope.asset = $scope.asset || {};
    
    $scope.frequencyOfUpdatesList = [
        "UNKNOWN",
        "LOW",
        "MED",
        "HIGH"
    ];

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Assets/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        AssetResource.save($scope.asset, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Assets");
    };
});