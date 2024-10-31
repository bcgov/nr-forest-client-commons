# Oracle Database Client Connection Certificate Extractor

This repository contains a utility for extracting the connection certificate from an Oracle Database client. This image will acquire a secure connection to the server host and port and it will extract the connection certificate from it.

## Usage

To use the Oracle Database Client Connection Certificate Extractor as part of your openshift deployment, follow these steps:

1. On your Deployment, add the initContainers (same as an actual container)
2a. Set the image as `ghcr.io/bcgov/nr-forest-client-commons/certextractor:X.Y.Z`
2b. Create a new ImageStream and reference `ghcr.io/bcgov/nr-forest-client-commons/certextractor:X.Y.Z`

## Contributing

Contributions are welcome! If you would like to contribute to the Oracle Database Client Connection Certificate Extractor, please follow these guidelines:

1. Fork this repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your branch to your forked repository.
5. Open a pull request to merge your changes into the main repository.

## License

This project is licensed under the [Apache 2.0](../LICENSE).

## Example usage

Keep in mind that this is just an example, adapt it to your requirements.

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
