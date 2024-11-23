# Hibernate 6 issue
This example was primary created to particular SQL syntax with Spring Data JPA.
## Primary Case
In the Spring Boot version 3.1.0 the example is not working but with the version 3.1.4 it does.
This is because with the Spring Boot version 3.1.4 Hibernate 6.2.9.Final is used where the problem is solved where in Spring Boot version 3.1.0 the Hibernate 6.2.2.Final is used.

Change the Spring Boot version in the gradle project to test the different cases.
Execute the test class `DataJpaByDayProblemIntegrationTest`.
## Secondary case
Reading the data with entity manager by creating native query and using custom row mapper by:
* JPA - SqlResultSetMapping - ConstructorResult
* JPA - TupleClass 
* Hibernate - TupleTransformer

## Links
* https://vladmihalcea.com/the-best-way-to-map-a-projection-query-to-a-dto-with-jpa-and-hibernate/
* https://thorben-janssen.com/result-set-mapping-basics/
* https://thorben-janssen.com/hibernate-resulttransformer/
* https://stackoverflow.com/questions/25188939/how-to-map-the-result-set-of-a-jpa-nativequery-to-a-pojo-using-sqlresultsetmappi
* https://stackoverflow.com/questions/46171583/jpa-data-repositories-with-sqlresultsetmapping-and-native-queries
* https://www.woolha.com/tutorials/hibernate-using-tupletransformer-resultlisttransformer