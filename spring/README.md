# Forest Client Spring Commons Library

This library contains components that are tied to the Spring Boot framework,
in order to use it just add the following dependency to your pom file:

```
<dependency>
    <groupId>ca.bc.gov.nrs-commons</groupId>
    <artifactId>forest-client-spring</artifactId>
    <version>{version}</version>
</dependency>
```

In order to import it, configure your github user inside your settings.xml file

```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
	        <id>github</id>
	        <username>MYSUERNAME</username>
	        <password>MYTOKEN</password>
	    </server>
    </servers>
</settings>
```

Remember to create a token on the [tokens configuration](https://github.com/settings/tokens) and add `read:packages` in order to access the repository
