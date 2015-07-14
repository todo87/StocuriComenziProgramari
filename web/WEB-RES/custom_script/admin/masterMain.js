depo.controller('masterMainController', ['$scope', '$http', function ($scope, $http) {
    $scope.listOfTables = null ;
    $http.post('/test/listOfTables').success(function(response){
      $scope.listOfTables = response;
    });

}]);
