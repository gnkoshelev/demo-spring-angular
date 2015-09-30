import Promise = require('commons/Promise');
import Tag = require('model/Tag');

class TagService {
    public http:ng.IHttpService;
    public contextPath:string;
    public q:ng.IQService;
    public url:string;

    public static injection():any[] {
        return ['$http', 'contextPath', '$q', ($http:ng.IHttpService, contextPath:string, $q:ng.IQService) => new TagService($http, contextPath, $q)];
    }

    public constructor($http:ng.IHttpService, contextPath:string, $q:ng.IQService) {
        this.http = $http;
        this.contextPath = contextPath;
        this.q = $q;
        this.url = this.contextPath + "/api/tags";
    }

    public suggest(pattern: string): ng.IPromise<string[]> {
        return Promise.promise(
            this.http.get<string[]>(
                this.url + "/suggest",
                {
                    params: {
                        pattern: pattern
                    }
                }
            ),
            this.q
        );
    }

    public list(names: string[]): ng.IPromise<Tag[]> {
        return Promise.promise(
            this.http.get<Tag[]>(
                this.url + "/list",
                {
                    params: {
                        names: (names != null) ? names.join(' ') : null
                    }
                }),
            this.q)
    }

    public get(name: string): ng.IPromise<Tag> {
        return Promise.promise(
            this.http.get<Tag>(
                this.url + "/get",
                {
                    params: {
                        name: name
                    }
                }
            ),
            this.q);
    }
}

export = TagService;