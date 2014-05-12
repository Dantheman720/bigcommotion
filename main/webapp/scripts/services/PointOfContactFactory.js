angular.module('bigCommotion').factory('PointOfContactResource', function($resource){
    var resource = $resource('rest/pointofcontacts/:PointOfContactId',{PointOfContactId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});