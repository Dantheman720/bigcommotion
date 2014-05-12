
angular.module('bigCommotion').controller('NewPresenterController', function ($scope, $location, locationParser, PresenterResource ) {
    $scope.disabled = false;
    $scope.presenter = $scope.presenter || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Presenters/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        PresenterResource.save($scope.presenter, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Presenters");
    };
});