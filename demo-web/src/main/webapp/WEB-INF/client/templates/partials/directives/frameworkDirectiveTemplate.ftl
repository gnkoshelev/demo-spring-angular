<#import "/spring.ftl" as spring>
<div>
    <div ng-repeat="tag in framework.tags">
        <h4><@spring.message "model.Tag"/>: {{tag.name}}</h4>
        <p><@spring.message "model.Tag.Followers"/>: {{tag.followers}}</p>
        <p><@spring.message "model.Tag.Questions"/>: {{tag.questions}}</p>
    </div>
</div>