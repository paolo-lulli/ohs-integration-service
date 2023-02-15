# OHS Integration Service

## Integration Service

[integration-service](ohs-api-test/integration-service/) is a modular project, composed by two Maven modules:

- [stub](ohs-api-test/integration-service/stub) to generate stubs for gRpc interaction
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

A [Dockerfile](ohs-api-test/Dockerfile) is provided to build the application, e.g. by doing:

```
cd ohs-api-test/integration-service
docker build -t "ohc-integration-service" .
```

