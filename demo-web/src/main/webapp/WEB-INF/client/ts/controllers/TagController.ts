import Tag = require('model/Tag');

import TagService = require('services/TagService');

export class TagController {
    tagService:TagService;

    selectedTag: string;
    selectedTags: string[];
    loadedTags: {[key:string] : Tag};

    public constructor(tagService: TagService) {
        this.tagService = tagService;

        this.selectedTag = null;
        this.selectedTags = [];
        this.loadedTags = {};
    }

    public suggest(tag:string) {
        return this.tagService.suggest(tag).then(
            (suggests:string[]) => {
                return suggests;
            },
            (error:any) => {
                //TODO: Alert
            }
        );
    }

    public selectTag() {
        var tagName = this.selectedTag;
        var _this = this;
        if (this.selectedTags.indexOf(tagName) == -1) {
            this.selectedTags.push(tagName);
            this.tagService.get(tagName).then(
                (tag:Tag) => {
                    _this.loadedTags[tag.name] = tag;
                }
            )
        }
        this.selectedTag = null;
    }

    public cleanSelectedTags() {
        this.selectedTags = [];
        this.loadedTags = {};
    }
}

export function inject(app: ng.IModule):void {
    app.controller(
        "TagController",
        [
            'tagService',
            (tagService:TagService) => new TagController(tagService)
        ]);
}

