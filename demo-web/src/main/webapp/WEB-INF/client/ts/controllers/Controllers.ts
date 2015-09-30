import MainController = require('controllers/MainController');
import FrameworkController = require('controllers/FrameworkController');
import TagController = require('controllers/TagController');

export function init(app: ng.IModule): void {
    MainController.inject(app);
    FrameworkController.inject(app);
    TagController.inject(app);
}