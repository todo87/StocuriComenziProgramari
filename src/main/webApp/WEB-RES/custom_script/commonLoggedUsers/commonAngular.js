var depo = angular.module('depo',['ngTouch','ui.grid','ngDialog']);
depo.config(function($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

});