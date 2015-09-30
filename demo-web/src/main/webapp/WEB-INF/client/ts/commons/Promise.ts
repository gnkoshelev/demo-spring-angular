export function promise(promise: ng.IHttpPromise<any>, q: ng.IQService): ng.IPromise<any> {
    var deferred = q.defer();
    promise.success((data) => {
        deferred.resolve(data);
    }).error((data) => {
        deferred.reject(data);
    });
    return deferred.promise;
}