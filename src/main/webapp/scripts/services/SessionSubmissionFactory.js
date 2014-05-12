angular.module('bigCommotion').factory('SessionSubmissionResource', function($resource){
    var resource = $resource('rest/sessionsubmissions/:SessionSubmissionId',{SessionSubmissionId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});