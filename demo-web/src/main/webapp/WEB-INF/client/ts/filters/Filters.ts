import FrameworkFilter = require('filters/FrameworkFilter')

export function init(app:ng.IModule) {
    app.filter('frameworkFilter', FrameworkFilter.create());
}