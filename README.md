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
