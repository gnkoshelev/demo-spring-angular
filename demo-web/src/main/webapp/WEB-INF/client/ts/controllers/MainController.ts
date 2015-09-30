import Framework = require('model/Framework');

import FrameworkService = require('services/FrameworkService');

/**
 * Use scope for $watch, $on, $emit, $broadcast
 * Use scope (in rare cases) for sharing data and functions
 */
export interface MainScope extends ng.IScope {
}

export class MainController {
    location: ng.ILocationService;

    public constructor($scope: MainScope, $location: ng.ILocationService, frameworkService: FrameworkService) {
        console.debug('Create MainController');
        this.location = $location;
    }

    public isActive(path:string):boolean {
        return (path === '/') ? this.location.path() === path : this.location.path().substr(0, path.length) === path;
    }
}

export function inject(app: ng.IModule): void {
    app.controller(
        'MainController',
        [
            '$scope', '$location', 'frameworkService',
            ($scope: MainScope, $location:ng.ILocationService, frameworkService: FrameworkService) => new MainController($scope, $location, frameworkService)
        ]);
}
