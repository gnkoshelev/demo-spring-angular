<div class="container">
    <input type="text" ng-model="tagController.selectedTag" placeholder="Tags"
           typeahead="tag for tag in tagController.suggest($viewValue)" typeahead-on-select="tagController.selectTag()"
           class="form-control">
    <label class="btn btn-info" ng-click="tagController.cleanSelectedTags()">Очистить список</label>
    <ul class="list-inline">
        <li ng-repeat="tagName in tagController.selectedTags" tooltip-template="'tagTooltip.html'">{{tagName}}</li>
    </ul>
    <script type="text/ng-template" id="tagTooltip.html">
        <span ng-if="!!tagController.loadedTags[tagName]"><span>Подписчики: {{tagController.loadedTags[tagName].followers}}, Вопросы: {{tagController.loadedTags[tagName].questions}}</span></span>
        <span ng-if="!tagController.loadedTags[tagName]">Данные на загружены</span>
    </script>
</div>  