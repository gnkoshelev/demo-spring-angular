<div class="container">
    <div>
        <h2>Добавить фреймворк к сравнению</h2>
        <div class="form-horizontal">
            <div class="form-group">
                <label>Название фреймворка:</label>
                <input type="text" ng-model="frameworkController.item.name" ng-disabled="frameworkController.item == null" class="form-control">
            </div>
            <div class="form-group">
                <label>Связанные тэги:</label>
                <input type="text" ng-model="frameworkController.item.tagNames" ng-list ng-disabled="frameworkController.item == null" class="form-control">
            </div>
            <button type="button" class="btn btn-default" ng-click="frameworkController.create()">Добавить</button>
        </div>
    </div>
    <div>
        <h2>Популярность фреймворков (показано <span class="badge">{{filtered.length}}</span> из <span class="badge">{{frameworkController.frameworks.length}}</span>)</h2>
        <div class="form-horizontal">
            <div class="form-group">
                <label>Followers:</label>
                <input type="text" ng-model="frameworkController.filter.f" class="form-control">
            </div>
            <div class="form-group">
                <label>Questions:</label>
                <input type="text" ng-model="frameworkController.filter.q" class="form-control">
            </div>
            <div class="form-group">
                <label>Sort by</label>
                <div class="btn-group">
                    <label class="btn btn-primary" ng-model="frameworkController.order" btn-radio="'maxFollowers'">Followers</label>
                    <label class="btn btn-primary" ng-model="frameworkController.order" btn-radio="'maxQuestions'">Questions</label>
                </div>
            </div>
        </div>
        <div ng-mouseleave="frameworkController.unselect()" class="row">
            <div class="col-xs-3">
                <div ng-repeat="framework in filtered = (frameworkController.frameworks | frameworkFilter:frameworkController.filter) | orderBy:frameworkController.order:true">
                    <h3 ng-mouseover="frameworkController.select(framework)"><span>{{framework.name}}</span></h3>
                </div>
            </div>
            <div class="col-xs-3">
                <div framework-directive framework="frameworkController.selected"></div>
            </div>
        </div>
    </div>
</div>