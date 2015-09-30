import FrameworkService = require('services/FrameworkService');
import TagService = require('services/TagService');

export function init(app: ng.IModule): void {
    app.factory('frameworkService', FrameworkService.injection());
    app.factory('tagService', TagService.injection());
}