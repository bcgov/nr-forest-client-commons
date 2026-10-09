[![MIT License](https://img.shields.io/github/license/bcgov/quickstart-openshift.svg)](/LICENSE.md)
[![Lifecycle](https://img.shields.io/badge/Lifecycle-Experimental-339999)](https://github.com/bcgov/repomountie/blob/master/doc/lifecycle-badges.md)

# Forest Client Commons

This repository holds the Oracle Database Client Connection Certificate Extractor image (`certextractor/`), used by [forest client applications](https://github.com/bcgov/nr-forest-client) and other NRS apps to extract the database certificate from Oracle.

## Oracle Database Client Connection Certificate Extractor

This is an utility for extracting the connection certificate from an Oracle Database client. This image will acquire a secure connection to the server host and port and it will extract the connection certificate from it.


```yml
- apiVersion: apps/v1
    kind: Deployment
    metadata:
      labels:
        app: application-name
      name: application-component
    spec:
      replicas: 1
      selector:
        matchLabels:
          deployment: application-component
      strategy:
        type: RollingUpdate
      template:
        metadata:
          labels:
            app: application-name
            deployment: application-component
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
