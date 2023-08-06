# Query Method
## Source
* [Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods)
* [Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)
* [Ultimate Guide: Derived Queries with Spring Data JPA](https://www.youtube.com/watch?v=GVeY08vUiPE)
## Introduction
Query Method can be used when own repository implements the class which extends the Repository interface.
Then the method name which contains the teble properties is used as select statement.
Look in the sources for more informations.
## Components
    * Repository<ENTITY_NAME, ID_TYPE>