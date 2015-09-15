depo.controller('masterMainController', ['$scope', '$http', function ($scope, $http) {
    $scope.listOfTables = null;
    $scope.tableData = {};

    $scope.onClick = function(){
        getTableData($scope.valueSelected).success(function(response) {
            $scope.tableData = response;
            console.log(response);
        });
    };

    $http.post('/master/listOfTables').success(function (response) {
        $scope.listOfTables = response;
        console.log(response);
    });

    function getTableData(table) {
        return $http.post('/master/tableData/' + table);
    }


}]);



