# Query by Example
## Source
* [Query by Example](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example)
* [Spring Data JPA Query by Example](https://www.baeldung.com/spring-data-query-by-example)
## Introduction 
Query by Example (QBE) is a user-friendly querying technique with a simple interface. It allows dynamic query creation and does not require you to write queries that contain field names. In fact, Query by Example does not require you to write queries by using store-specific query languages at all.
## Components
    - ExampleMatcher
    - Example<TYPE>
    - Example.of