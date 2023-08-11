# Spring JPA DB table relation
This is a project where the different DB table relations are implemented with Spring JPA.

_Source:_
* [Spring Data JPA Relationships - ManyToMany, ManyToOne & OneToMany](https://www.youtube.com/watch?v=CvDS6DltIno)
* [JPA & Hibernate: Basic Annotations You Need To Know](https://www.youtube.com/watch?v=GKIXI_Vc28k)
* [Hibernate - Chapter 24. Best Practices](https://docs.jboss.org/hibernate/core/3.3/reference/en/html/best-practices.html)
* [What is the "owning side" in an ORM mapping?](https://stackoverflow.com/questions/2749689/what-is-the-owning-side-in-an-orm-mapping)
--- 
* [What is the difference between Unidirectional and Bidirectional JPA and Hibernate associations?](https://stackoverflow.com/questions/5360795/what-is-the-difference-between-unidirectional-and-bidirectional-jpa-and-hibernat)
> The main difference is that bidirectional relationship provides navigational access in both directions, so that you can access the other side without explicit queries. Also it allows you to apply cascading options to both directions.
> 
> Note that navigational access is not always good, especially for "one-to-very-many" and "many-to-very-many" relationships. Imagine a Group that contains thousands of Users:
> * How would you access them? With so many Users, you usually need to apply some filtering and/or pagination, so that you need to execute a query anyway (unless you use collection filtering, which looks like a hack for me). Some developers may tend to apply filtering in memory in such cases, which is obviously not good for performance. Note that having such a relationship can encourage this kind of developers to use it without considering performance implications.
> * How would you add new Users to the Group? Fortunately, Hibernate looks at the owning side of relationship when persisting it, so you can only set User.group. However, if you want to keep objects in memory consistent, you also need to add User to Group.users. But it would make Hibernate to fetch all elements of Group.users from the database!
> 
> So, I can't agree with the recommendation from the Best Practices. You need to design bidirectional relationships carefully, considering use cases (do you need navigational access in both directions?) and possible performance implications.

Best Practices:
> Prefer bidirectional associations:
Unidirectional associations are more difficult to query. In a large application, almost all associations must be navigable in both directions in queries.

## One-To-One relation
Association types:
* Foreign Key
   * Unidirectional association
   * Bidirectional association - owning side 
* Shared Primary Key
* Join Table

_Based on:_ [One-to-One Relationship in JPA](https://www.baeldung.com/jpa-one-to-one)
## One-To-Many and Many-to-One relation
Association types:
* Unidirectional association
  * ~~One-to-Many~~
  * Many-to-One
* Bidirectional association - owning side
  * One-to-Many
  * Many-to-One
* @ElementCollection
* JoinTable

**Warning:** Do not use unidirectional one-to-many association. Under the hood an extra table is created for the relation and many unnecessary operations are exectued. See the source for more inforamtion.

_Based on:_
* [Best Practices for Many-To-One and One-To-Many Association Mappings](https://thorben-janssen.com/best-practices-many-one-one-many-associations-mappings/)
* [Best Practices for Many-To-One and One-To-Many Association Mappings](https://www.youtube.com/watch?v=tciSOIQngig)
* [Hibernate One to Many Annotation Tutorial](https://www.baeldung.com/hibernate-one-to-many)
## Many-to-Many relation
Association types:
* Basic Implementation
* Using a Composite Key
* With a New Entity

_Based on:_[Many-To-Many Relationship in JPA](https://www.baeldung.com/jpa-many-to-many)
