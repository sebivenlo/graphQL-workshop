# graphQL-workshop

ESDE 2020 - Workshop on GraphQL

## Introduction

Welcome to our workshop on GraphQL.

The slides will be uploaded to the repo after the workhop.
This page will focus on setting up the demo application on your personal machine.

## Installation

The demo application is a simple maven project.

### Prerequisites

* An IDE (Netbeans, IntelliJ etc.)
* JDK 1,8+ installed with JAVA_HOME configured appropriatly. (https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/)
* Apache Maven 3.6.2+ (https://maven.apache.org/)

## Architecture

In this guide, we build a simple GraphQL application that exposes a GraphQL API at /graphql.

This example was inspired by a popular GraphQL API.

## Installation and Launch

Clone the repository and use maven to do a clean install.

```bash
git clone https://github.com/sebivenlo/graphQL-workshop.git
cd graphQL-workshop/graphql-example/
mvn clean install
```

After installation is complete you can open the application in your preferred IDE.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```bash
./mvnw quarkus:dev
```

on windows this command would be:

```bash
mvnw quarkus:dev
```

> You can find further instructions on running the application or building a native image [here](https://github.com/sebivenlo/graphQL-workshop/blob/master/graphql-example/README.md).

## Introspect

The full schema of the GraphQL API can be retrieved by calling the following:

```bash
curl http://localhost:8080/graphql/schema.graphql
```

The server will return the complete schema of the GraphQL API.

## GraphiQL

GraphiQL can be accessed from <http://localhost:8080/graphql-ui/>

## Assignment

We would like to extend the api by allowing clients to retrieve Hero data of the Film, so that this query:

```bash
query allFilms {
  film(filmId: 4) {
    title
    releaseDate
    episodeID
    director
    heroes{
      name
      darkSide
    }
  }
}
```

Produces this result:

```json
{
  "data": {
    "film": {
      "title": "A New Hope",
      "releaseDate": "1977-05-25",
      "episodeID": 4,
      "director": "George Lucas",
      "heroes": [
        {
          "name": "Luke",
          "darkSide": false
        },
        {
          "name": "Leia",
          "darkSide": false
        },
        {
          "name": "Darth",
          "darkSide": true
        },
        {
          "name": "Obi-Wan",
          "darkSide": false
        }
      ]
    }
  }
}
```

>TIP The source annotation should be used like so:
>
> ```java
> public List<Hero> heroes(@Source Film film)  {
> ...
> }
>```
