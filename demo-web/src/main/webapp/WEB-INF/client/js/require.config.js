require.config({
    baseUrl: 'js',

    paths: {
        'angular': '../libs/angularjs/angular',
        'angular-route': '../libs/angularjs/angular-route',
        'jquery': '../libs/jquery/jquery',
        'angular-ui-bootstrap': '../libs/angular-ui/ui-bootstrap'
    },

    shim: {
        'jquery': {
            exports: '$'
        },
        'angular': {
            exports: 'angular',
            deps: ['jquery']
        },
        'angular-route': {
            exports: 'angular-route',
            deps: ['angular']
        },
        'angular-ui-bootstrap': {
            exports: 'angular-ui-bootstrap',
            deps: ['angular']
        }
    }
});

require(
    [
        'angular',
        'angular-route',
        'angular-ui-bootstrap',
        'jquery',
        'application'
    ],
    function(angular) {
        angular.bootstrap(document, ['demoApp']);
    }
)