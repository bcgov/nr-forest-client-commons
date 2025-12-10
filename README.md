[![MIT License](https://img.shields.io/github/license/bcgov/quickstart-openshift.svg)](/LICENSE.md)
[![Lifecycle](https://img.shields.io/badge/Lifecycle-Experimental-339999)](https://github.com/bcgov/repomountie/blob/master/doc/lifecycle-badges.md)

# Oracle Database Client Connection Certificate Extractor

This repository contains a utility for extracting the connection certificate from an Oracle Database client.

This image will acquire a secure connection to the server host and port and extract the connection certificate from it.


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
