<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
<head>
    <base href="${rc.getContextPath()}/"/>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/app.css">
</head>
<body>
<h1><@spring.message "title.index"/></h1>
<div ng-controller="MainController as mainController">
    <ul class="nav  nav-pills">
        <li ng-class="{ active: mainController.isActive('/')}"><a href="#!/"><@spring.message "menu.info"/></a></li>
        <li ng-class="{ active: mainController.isActive('/frameworks')}"><a href="#!/frameworks"><@spring.message "menu.frameworks"/></a></li>
        <li ng-class="{ active: mainController.isActive('/tags')}"><a href="#!/tags"><@spring.message "menu.tags"/></a></li>
    </ul>
    <div ng-view></div>
</div>
<script src="libs/requirejs/require.js" type="text/javascript"></script>
<script src="js/require.config.js" type="text/javascript"></script>
</body>
</html>