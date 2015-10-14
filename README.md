# demo-spring-angular
Demo Java project based on Spring MVC and AngularJS.

## Server-side
* Spring Framework (Core, MVC), version *4.2.1.RELEASE*
* FreeMarker as Template Engine, version *2.3.21*
* Jackson as JSON Processor, version *2.6.1*
* MongoDB as storage, version *3.0.6*
* Morphia as ORM, version *1.0.1*
* Tomcat, version *7.0.64*

### Additional Libs
* MongoDB Driver, version *3.0.2*
* HTML Parser JSOUP, version *1.8.3*
* Joda Date Time, version *2.6*
* Servlet API, version *2.5*

## Client-side
* RequireJS, version *2.1.20*
* AngularJS, version *1.4.6*
* Angular UI Bootstrap, version *0.13.4*
* Twitter Bootstrap CSS, version *3.3.5*

### Additional Libs
* jQuery, version *2.1.4*

## Build Options
* Java 1.6+
* Maven, version *3.2.5*
* Node.js, version *0.12.2*
* TypeScript Compiler, version *1.6.2*
* [typescript-maven-plugin](https://github.com/gnkoshelev/typescript-maven-plugin), version *0.3*

### Build Steps
1. Install Node.js and TypeScript Compiler as module (npm -i g typescript)
2. Add typescript-maven-plugin to Maven Repository (mvn install:install-file -Dfile=typescript-maven-plugin-0.3.jar)
3. Build project with Maven (mvn clean package)

## Deploy
Check MongoDB configuration (see config.properties).

## Project structure
* See typescript-maven-plugin usage in demo-web/pom.xml
* All dependencies defined in demo-web/pom.xml

### Server-side
pkg-prefix = java/ru/gnkoshelev/demo/spring_angular/web
* webapp/WEB-INF/web.xml - Web application entry point (configuring Servlet and Context loader).
* webapp/WEB-INF/spring.xml - Root context configuration (refer to resources/beans.xml).
* resources/beans.xml - Base application config (activating annotations, importing bean definitions).
* resources/mongo.xml - MongoDB + Morphia configuration.
* resources/spring-mvc.xml - Spring MVC configuration (ViewResolver, Static resource mapping, Message converters and Localization).
* resources/config.properties - Application properties.
* resources/i18n/messages_<locale>.properties - Localization config (see resources/spring-mvc.xml>messageSource and views implementations).
* *&lt;pkg-prefix&gt;*/controller/RootController - View Controller.
* *&lt;pkg-prefix&gt;*/controller/api/* - REST JSON API.
* *&lt;pkg-prefix&gt;*/model/* - Entities (Morphia annotations).
* *&lt;pkg-prefix&gt;*/mongo/* - Utility code for DB Layer.
* *&lt;pkg-prefix&gt;*/repository/* - DB Layer.
* *&lt;pkg-prefix&gt;*/service/* - Business-logic Layer.
* *&lt;pkg-prefix&gt;*/so/api/* - Utility code for StackOverflow.com 'API'.

### Client-side
base-dir = webapp/WEB-INF/client
* *&lt;base-dir&gt;*/css/* - Bootstrap CSS.
* *&lt;base-dir&gt;*/libs/* - Used JS libraries.
* *&lt;base-dir&gt;*/templates/* - FreeMarker templates.
* *&lt;base-dir&gt;*/js/require.config.js - RequireJS startup config.
* *&lt;base-dir&gt;*/ts/application.ts - Client application entry point.
* *&lt;base-dir&gt;*/ts/Routes.ts - Routing config.
* *&lt;base-dir&gt;*/ts/services/* - Services for accessing REST JSON API.
* *&lt;base-dir&gt;*/ts/model/* - Entities (direct map from server-side entities).
* *&lt;base-dir&gt;*/ts/filters/* - Filters (use in ng-repeat directive).
* *&lt;base-dir&gt;*/ts/directives/* - Custom AngularJS directives.
* *&lt;base-dir&gt;*/ts/commons/* - Common utility code.
* *&lt;base-dir&gt;*/ts/controllers/* - View controllers (see <base-dir>/ts/Routes.ts and templates).
* *&lt;base-dir&gt;*/ts/definitions/* - Typed Definitions for external JS libraries.
