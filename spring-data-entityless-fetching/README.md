# Spring Data entityless fetching data from DB
## Introduction
The questin was, is it possible to fetch data from the DB without defining an entity which represents a database table.
In this project several approached are implemented, some with JDBC other with JPA, hoe to fetch data from the DB without DB table related entity.
## JDBC
Two approached were implemented:
* JdbcTemplate
* JdbcClient
## JPA
Four implementation are declared which are based on @SqlResultSetMapping
* Column Mapping
  * native query
  * named query
* Entity Mapping
  * native query
  * named query 

## Links
* @SqlResultSetMapping
  * https://www.baeldung.com/jpa-sql-resultset-mapping
  * https://vladmihalcea.com/jpa-sqlresultsetmapping/
* JdbcTemplate and JdbcClient
  * https://www.youtube.com/watch?v=qLDrfebeXS0
  * https://www.youtube.com/watch?v=ZKYFGuukhT4
  * https://www.baeldung.com/spring-6-jdbcclient-api* 
* MQQSL on MacOS
  * MSSQL on MacOSX (arm) - https://learn.microsoft.com/en-us/answers/questions/654108/azure-sql-edge-on-mac-m1-using-docker
  * 4.33.0 breaks containers like MSSQL - https://github.com/docker/for-mac/issues/7368
    * Azure images are not supported anymore - https://github.com/docker/for-mac/issues/7368#issuecomment-2622037429
  * Rancher desktop emulation preferences - https://docs.rancherdesktop.io/ui/preferences/virtual-machine/emulation/ (solution of my problem!)