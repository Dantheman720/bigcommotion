angular.module('bigCommotion').factory('AssetResource', function($resource){
    var resource = $resource('rest/assets/:AssetId',{AssetId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});