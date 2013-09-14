angular.module('bigCommotion').factory('UserGroupResource', function($resource){
    var resource = $resource('rest/usergroups/:UserGroupId',{UserGroupId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});