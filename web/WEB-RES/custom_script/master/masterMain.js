depo.controller('masterMainController', ['$scope', '$http', 'ngDialog', function ($scope, $http, ngDialog) {
    $scope.listOfTables = null;
    $scope.tableData = [];
    $scope.tableHeads = [];
    $scope.selectedTable='';

    $scope.gridOptions = {
        enableSorting: true
    }

    $http.post('/master/listOfTables').success(function (response) {
        $scope.listOfTables = response.tables;
        $scope.selectedTable = response.selected;
        console.log(response);
        getTableDataAndBind($scope.selectedTable);
    });

    $scope.onClick = function(){
        getTableDataAndBind($scope.selectedTable);
    }

    function getTableDataAndBind(table){
        getTableData(table).success(function(response) {
            bindColumnDefsAndData(response);
        });
    }

    function getTableData(table) {
        return $http.post('/master/tableData/' + table);
    }

    function bindColumnDefsAndData(data){
        $scope.tableData = data;
        console.log(data);
        $scope.tableHeads = [];
        var keys = Object.keys(data[0]);
        for(var i = 0; i<keys.length; i++){
            var obj = { name: keys[i], field: keys[i] };
            $scope.tableHeads.push(obj);
        }
        $scope.gridOptions.columnDefs = $scope.tableHeads;
        $scope.gridOptions.data = data;
    }

    $scope.addPopUp = function () {
        ngDialog.openConfirm({
            template: 'dialogWithNestedConfirmDialogId',
            className: 'ngdialog-theme-default',
            preCloseCallback: function(value) {

                var nestedConfirmDialog = ngDialog.openConfirm({
                    template:
                    '<p>Are you sure you want to close the parent dialog?</p>' +
                    '<div class="ngdialog-buttons">' +
                    '<button type="button" class="ngdialog-button ngdialog-button-secondary" ng-click="closeThisDialog(0)">No' +
                    '<button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="confirm(1)">Yes' +
                    '</button></div>',
                    plain: true,
                    className: 'ngdialog-theme-default'
                });

                return nestedConfirmDialog;
            },
            scope: $scope
        })
            .then(function(value){
                console.log('resolved:' + value);
                // Perform the save here
            }, function(value){
                console.log('rejected:' + value);

            });
    };
}]);



