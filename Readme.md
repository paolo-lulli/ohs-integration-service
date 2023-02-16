# OHS Integration Service

## Integration Service

[integration-service](ohs-api-test/integration-service/) is a modular project, composed by two Maven modules:

- [stubs](ohs-api-test/integration-service/stubs) to generate stubs for gRpc interaction
- [service](ohs-api-test/integration-service/service) the actual business logic

## Requirements

-  JDK 17
-  Maven 3.6.x
-  Docker Compose 2.x

## Building the application

The application can be built with the following commands:

```
cd ohs-api-test/integration-service
mvn clean install
```

## Running the application

After running the dependencies with:

```
cd ohs-api-test/intel
docker-compose up
```

the application can be run with the following commands:

```
cd ohs-api-test/integration-service
java -jar service/target/integration-service-0.0.1.jar
```

Also a convenience script is added for local development: [run.sh](ohs-api-test/integration-service/run.sh)

A [Dockerfile](ohs-api-test/Dockerfile) is provided to build the application, e.g. by doing:

```
cd ohs-api-test/integration-service
docker build -t "ohc-integration-service" .
```

## Screenshots

It is possible to check locally that the users get written.

![Users Written](https://github.com/paolo-lulli/ohs-integration-service/blob/master/screenshot/written-users.png)

On my local machine it is possible to see traces.

![Traces in Jaeger](https://github.com/paolo-lulli/ohs-integration-service/blob/master/screenshot/jaeger-traces.png)

Also products are saved, since the name of the prod is not available the name is hardcoded as the string: **Not Mapped**
![Products Saved](https://github.com/paolo-lulli/ohs-integration-service/blob/master/screenshot/products-saved.png)

