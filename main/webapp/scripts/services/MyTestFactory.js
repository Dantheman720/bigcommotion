angular.module('bigCommotion').factory('MyTestResource', function($resource){
    var resource = $resource('rest/mytests/:MyTestId',{MyTestId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});