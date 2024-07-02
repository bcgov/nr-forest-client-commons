[![MIT License](https://img.shields.io/github/license/bcgov/quickstart-openshift.svg)](/LICENSE.md)
[![Lifecycle](https://img.shields.io/badge/Lifecycle-Experimental-339999)](https://github.com/bcgov/repomountie/blob/master/doc/lifecycle-badges.md)

# Forest Client Commons Library

This repository holds common code shared between all [forest client applications](https://github.com/bcgov/nr-forest-client) and [api](https://github.com/bcgov/nr-forest-client-api) along with an image responsible for extracting database certificate from oracle.

To use this repository, you need to include it as a Maven repository in your project's `pom.xml` file. Add the following code snippet inside the `<repositories>` section:

```xml
<repository>
  <id>github</id>
  <name>Github Packages</name>
  <url>https://maven.pkg.github.com/bcgov/nr-forest-client-commons</url>
  <snapshots>
    <enabled>false</enabled>
  </snapshots>
</repository>
```

Next, you will need to include one of the two dependencies from this repository in your project. Add the following code snippets inside the `<dependencies>` section of your `pom.xml` file. Make sure to replace `X.Y.Z` with the appropriate version number.

By including the repository and dependencies as mentioned, you will be able to utilize the common code shared between all forest client applications and the API. This repository provides essential functionality and utilities that can be leveraged to enhance your forest client projects. Ensure that you have the necessary access and permissions to the repository in order to successfully include it in your project.

Remember to regularly check for updates and new releases of the dependencies to ensure you are using the latest features and bug fixes.

## Core library

The core library contains DTOs and utility classes that are framework independent and serve as a way to share DTO classes between applications.

```xml
<dependency>
  <groupId>ca.bc.gov.nrs-commons</groupId>
  <artifactId>forest-client-core</artifactId>
  <version>X.Y.Z</version>
</dependency>
```

## Spring library

The spring library implements the core library and make use of the spring framework, more specifically the spring boot framework. If you want to reuse some of the spring code that is generic. In case you want to use this, you can skip the core one, as it will be included as well.

```xml
<dependency>
  <groupId>ca.bc.gov.nrs-commons</groupId>
  <artifactId>forest-client-spring</artifactId>
  <version>X.Y.Z</version>
</dependency>
```


## Oracle Database Client Connection Certificate Extractor

This is an utility for extracting the connection certificate from an Oracle Database client. This image will acquire a secure connection to the server host and port and it will extract the connection certificate from it.


```yml
- apiVersion: v1
    kind: DeploymentConfig
    metadata:
      labels:
        app: application-name
      name: application-component
    spec:
      replicas: 1
      selector:
        deploymentconfig: application-component
      strategy:
        type: Rolling
      template:
        metadata:
          labels:
            app: application-name
            deploymentconfig: application-component
        spec:
          volumes:
            - name: application-name-certs
              persistentVolumeClaim:
                claimName: app-name-pvc
          initContainers:
            - name: certextract
              image: ghcr.io/bcgov/nr-forest-client-commons/certextractor:X.Y.Z
              imagePullPolicy: Always
              env:
                - name: ORACLEDB_HOST
                  value: host
                - name: ORACLEDB_SECRET
                  value: secret
                - name: ORACLEDB_PORT
                  value: "1521"
              volumeMounts:
                - name: application-name-certs
                  mountPath: /cert              
          containers:
            - image: your-app-image              
              volumeMounts:
                - mountPath: /cert
                  name: application-name-certs
```