/// <reference path="definitions/angularjs/angular-route.d.ts"/>
export function init($routeProvider: angular.route.IRouteProvider, cp: string): void {
    $routeProvider.when("/", {templateUrl: cp + 'partials/home'});
    $routeProvider.when("/frameworks", {templateUrl: cp + 'partials/frameworks', controller: 'FrameworkController', controllerAs: 'frameworkController'});
    $routeProvider.when("/tags", {templateUrl: cp + 'partials/tags', controller: 'TagController', controllerAs: 'tagController'});
}