var depo = angular.module('depo', ['ngRoute']);

depo.config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/main', {
                //TODO
                resolve: resolveController('/res/custom_script/admin/mainController.js')
            })

    }]);