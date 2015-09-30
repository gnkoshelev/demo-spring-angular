import Framework = require('model/Framework');
import Tag = require('model/Tag');

export function create() {
    return [() => {
        return (items:Framework[], filter:{q:number,f:number}) => {
            if (!filter.q && !filter.f) {
                return items;
            }

            var filtered = [];
            angular.forEach(items, (item:Framework) => {
                var ok:boolean = false;
                angular.forEach(item.tags, (tag:Tag) => {
                    if ((!filter.f || tag.followers >= filter.f) && (!filter.q || tag.questions >= filter.q)) {
                        ok = true;
                    }
                });
                if (ok) {
                    filtered.push(item);
                }
            });
            return filtered;
        };
    }];
}