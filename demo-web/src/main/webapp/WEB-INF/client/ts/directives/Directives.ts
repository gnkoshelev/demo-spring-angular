import FrameworkDirective = require('directives/FrameworkDirective');

export function init(app: ng.IModule) {
    app.directive('frameworkDirective', FrameworkDirective.create());
}