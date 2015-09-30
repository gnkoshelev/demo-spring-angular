import Tag = require('model/Tag');

class Framework {
    name: string;
    tags: Tag[];
    maxFollowers: number;
    maxQuestions: number;
}

export = Framework;