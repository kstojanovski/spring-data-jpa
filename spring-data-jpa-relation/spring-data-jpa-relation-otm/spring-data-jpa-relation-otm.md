# One-To-Many and Many-to-One relation
## Introduction
### Based on
* [Best Practices for Many-To-One and One-To-Many Association Mappings](https://thorben-janssen.com/best-practices-many-one-one-many-associations-mappings/)
* [Best Practices for Many-To-One and One-To-Many Association Mappings](https://www.youtube.com/watch?v=tciSOIQngig)
* [Hibernate One to Many Annotation Tutorial](https://www.baeldung.com/hibernate-one-to-many)
### Association types
* Unidirectional association
  * ~~One-to-Many~~
  * Many-to-One
* Bidirectional association - owning side
  * One-to-Many
  * Many-to-One
* @ElementCollection
### Warning
 * Do not use unidirectional one-to-many association. Under the hood an extra table is created for the relation and many unnecessary operations are exectued. See the source for more inforamtion.
### Note
* Owning side is the @ManyToOne anotated entity which also contains the foreign key in the @JoinColumn.
* Implement helper methods to update bidirectional associations.
## Unidirectional association
### Many-to-One
## Bidirectional association - owning side
### One-to-Many
### Many-to-One
### @ElementCollection
#### Source 
* [Java Persistence/Embeddables](https://en.wikibooks.org/wiki/Java_Persistence/Embeddables)
* [Hibernate Tip: How to use @ElementCollection entries in a query - Thorben Janssen](https://www.youtube.com/watch?v=ZIUNfJAhDv4)
#### Introduction
A collection of embeddable objects is similar to a OneToMany except the target objects are embeddables and have no Id. This allows for a OneToMany to be defined without a inverse ManyToOne, as the parent is responsible for storing the foreign key in the target object's table.
#### Components
Following elements belong to this appoach:
* @ElementCollection#
* @Embeddable
* @Embedded
#### Warning
This approch does not work efficiently and should be used only when on the many side few elements exist. 
