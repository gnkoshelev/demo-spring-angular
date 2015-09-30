import Framework = require('model/Framework');

export function create() {
    return [() => {
        return {
            restrict: 'A',
            templateUrl: 'partials/directives/frameworkDirectiveTemplate',
            transclude: true,
            scope: {
                framework: '='
            },
            link: (scope, element, attrs, controllers) => {
                console.debug('call link function for FrameworkDirective');
            }
        }
    }];
}