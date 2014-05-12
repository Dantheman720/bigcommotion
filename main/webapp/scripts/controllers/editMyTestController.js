

angular.module('bigCommotion').controller('EditMyTestController', function($scope, $routeParams, $location, MyTestResource ) {
    var self = this;
    $scope.disabled = false;

    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.myTest = new MyTestResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/MyTests");
        };
        MyTestResource.get({MyTestId:$routeParams.MyTestId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.myTest);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.myTest.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/MyTests");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/MyTests");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.myTest.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});