
angular.module('bigCommotion').controller('NewMyTestController', function ($scope, $location, locationParser, MyTestResource ) {
    $scope.disabled = false;
    $scope.myTest = $scope.myTest || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/MyTests/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        MyTestResource.save($scope.myTest, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/MyTests");
    };
});