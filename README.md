# reactive-pg-client-example project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running PostgreSQL

```shell script
docker run -d --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name quarkus_test -e POSTGRES_USER=quarkus_test -e POSTGRES_PASSWORD=quarkus_test -e POSTGRES_DB=quarkus_test -p 5432:5432 postgres:11.7
```

## Create skeleton application

```shell script
mvn io.quarkus:quarkus-maven-plugin:1.11.5.Final:create \
    -DprojectGroupId=com.redhat.example \
    -DprojectArtifactId=reactive-pg-client-example \
    -DclassName="com.redhat.example.FruitResource" \
    -Dpath="/fruits" \
    -Dextensions="resteasy,reactive-pg-client,resteasy-mutiny"
```

## Add Extension

```shell script
./mvnw quarkus:add-extension -Dextensions="resteasy-jackson"
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
mvn quarkus:dev
```

```shell script
./mvnw compile quarkus:dev
```

## Browser

http://localhost:8080/fruits

http://localhost:8080/fruits.html

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

## application.properties

```shell script
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=quarkus_test
quarkus.datasource.password=quarkus_test
quarkus.datasource.reactive.url=postgresql://localhost:5432/quarkus_test

quarkus.datasource.reactive.max-size=10
quarkus.datasource.reactive.cache-prepared-statements=true
quarkus.datasource.reactive.reconnect-attempts=1
quarkus.datasource.reactive.reconnect-interval=PT1S
quarkus.datasource.reactive.idle-timeout=PT60S

myapp.schema.create=true
```

It produces the `reactive-pg-client-example-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/reactive-pg-client-example-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/reactive-pg-client-example-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Reference

https://ja.quarkus.io/version/1.11/guides/reactive-sql-clients

https://github.com/quarkusio/quarkus-quickstarts/tree/1.11.6.Final/getting-started-reactive-crud