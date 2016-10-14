var carApp = angular.module('DemoApp', ["ngRoute"]);

carApp.controller('CarController', ["CarFactory", function (CarFactory) {
        var self = this;
        self.cars = [];
        console.log(CarFactory.getCars());
        self.cars = CarFactory.getCars();
        self.title = "Cars Demo App";
        self.predicate = "year";
        self.reverse = false;
        self.nextId = 5;

    }]);
carApp.controller('manageCarController', ["CarFactory", "$routeParams", function (CarFactory, $routeParams) {
        var self = this;
        self.car = $routeParams;
        self.cars = CarFactory.getCars();
        self.addCar = function (newcar) {
            CarFactory.addEditCar(newcar);
        };
    }]);

carApp.factory('CarFactory', '$http', function ($http) {
    //Return Cars from the server
    var getCars = function () {
        $http({
            method: 'GET',
            url: '/api/car'
        }).then(function successCallback(response) {
            return response.data;
            console.log(response.data);
        }, function errorCallback(response) {
            console.log("Det virker ikke");
        });
    };

//    //Delete Car on the Server
//    var deleteCar = function (id) {
//        $http({
//            method: 'Delete',
//            url: '/api/car'
//        }).then(function successCallback(response) {
//            return response.data;
//            console.log(response.data);
//        }, function errorCallback(response) {
//            console.log("Det virker ikke");
//        });
//    };
//
//    //Add Car on the Server
//    var addCar = function (newcar) {
//        $http({
//            method: 'POST',
//            url: '/api/car'
//        }).then(function successCallback(response) {
//            return response.data;
//            console.log(response.data);
//        }, function errorCallback(response) {
//            console.log("Det virker ikke");
//        });
//    };
//
//    //Edit Car on the Server;
//    var editCar = function (car) {
//        $http({
//            method: 'PUT',
//            url: '/api/car'
//        }).then(function successCallback(response) {
//            return response.data;
//            console.log(response.data);
//        }, function errorCallback(response) {
//            console.log("Det virker ikke");
//        });
//    };
    return {
        getCars: getCars, deleteCar: deleteCar, addCar: addCar, editCar: editCar
    };
});

carApp.config(["$routeProvider", function ($routeProvider) {
        $routeProvider
                .when("/allCars", {
                    templateUrl: "allCars.html",
                    controller: "CarController as ctrl"
                })
                .when("/addCar", {
                    templateUrl: "addCar.html",
                    controller: "manageCarController as manageCtrl"
                })
                .when("/editCar/:id", {
                    templateUrl: "editCar.html",
                    controller: "manageCarController as manageCtrl"
                })
                .otherwise("/");
    }]);
