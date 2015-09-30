///<reference path="definitions/angularjs/angular.d.ts"/>

import angular = require('angular');

import Routes = require('Routes');

import Directives = require('directives/Directives');
import Filters = require('filters/Filters');
import Services = require('services/Services');
import Controllers = require('controllers/Controllers');

var app = angular.module('demoApp', ['ngRoute', 'ui.bootstrap']);

var cp = angular.element('base').eq(0).attr('href');

app.value('contextPath', cp);

app.config(['$locationProvider', ($locationProvider: ng.ILocationProvider) => {
    $locationProvider.html5Mode(false).hashPrefix('!');
}]);

app.config(['$routeProvider', ($routeProvider) => {
    Routes.init($routeProvider, cp);
}]);

Directives.init(app);

Filters.init(app);

Services.init(app);

Controllers.init(app);