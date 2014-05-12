angular.module('bigCommotion').factory('PresenterResource', function($resource){
    var resource = $resource('rest/presenters/:PresenterId',{PresenterId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});