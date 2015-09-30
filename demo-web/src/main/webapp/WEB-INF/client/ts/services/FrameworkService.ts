import Promise = require('commons/Promise');
import Framework = require('model/Framework');

class FrameworkService {
    public http: ng.IHttpService;
    public contextPath: string;
    public q: ng.IQService;
    public url: string;

    public static injection(): any[] {
        return ['$http', 'contextPath', '$q', ($http: ng.IHttpService, contextPath: string, $q: ng.IQService) => new FrameworkService($http, contextPath, $q)];
    }

    public constructor($http: ng.IHttpService, contextPath: string, $q: ng.IQService) {
        this.http = $http;
        this.contextPath = contextPath;
        this.q = $q;
        this.url = this.contextPath + "/api/frameworks";
    }

    public list(): ng.IPromise<Framework[]> {
        return Promise.promise(this.http.get<Framework[]>(this.url + "/list"), this.q);
    }

    public create(name: string, tagNames: string[]): ng.IPromise<Framework> {
        return Promise.promise(
            this.http.post<Framework>(
                this.url + "/create", {},
                {
                    params: {
                        name: name,
                        tagNames: (tagNames != null) ? tagNames.join(' ') : null
                    }
                }),
            this.q)
    }
}

export = FrameworkService;