import Framework = require('model/Framework');

import FrameworkService = require('services/FrameworkService');

export class FrameworkController {
    private frameworkService: FrameworkService;

    frameworks: Framework[] = [];
    item: {name: string, tagNames: string[]} = {name: null, tagNames: null};
    selected: Framework;
    filter: {f:number,q:number} = {f:null, q:null};
    order:string = 'maxFollowers';

    constructor(frameworkService: FrameworkService) {
        this.frameworkService = frameworkService;

        this.frameworks = [];
        this.load();
    }

    private add(framework:Framework):void {
        if (this.frameworks == null) {
            this.frameworks = [];
        }
        this.frameworks.push(framework);
    }

    public load():void {
        var _this = this;
        this.frameworkService.list().then(
            (frameworks: Framework[]) => {
                _this.frameworks = frameworks;
            },
            (error: any) => {
                //TODO: Alert
            }
        )
    }

    public create():void {
        var _this = this;
        if (this.item != null) {
            this.frameworkService.create(this.item.name, this.item.tagNames).then(
                (framework: Framework) => {
                    _this.add(framework);
                },
                (error: any) => {
                    //TODO: Alert
                }
            );
            this.item = {name: null, tagNames: null};
        }
    }

    public select(framework:Framework):void {
        this.selected = framework;
    }

    public unselect():void {
        this.selected = null;
    }
}

export function inject(app: ng.IModule):void {
    app.controller(
        'FrameworkController',
        [
            'frameworkService',
            (frameworkService: FrameworkService) => new FrameworkController(frameworkService)
        ]);
}
