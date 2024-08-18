# JPA / Hibernate Annotations
Different JPA and Hibernate useful annotations are listed below with links to examples.
## @MappedSuperclass 
### jakarta.persistence.MappedSuperclass
- https://www.baeldung.com/hibernate-inheritance
- https://docs.oracle.com/javaee%2F7%2Fapi%2F%2F/javax/persistence/MappedSuperclass.html
## @EntityListeners
### jakarta.persistence.EntityListeners
```
// Kotlin code
// AuditTrailListener is defined somewhere else. See the examples.
@EntityListeners(AuditTrailListener::class)
```
- https://www.baeldung.com/jpa-entity-lifecycle-events
- https://docs.oracle.com/javaee%2F7%2Fapi%2F%2F/javax/persistence/EntityListeners.html
## @SQLRestriction
### org.hibernate.annotations.SQLRestriction
```
// Kotlin code
internal const val CUSTOMER_FILTER = """
    customer_id NOT IN (SELECT customer_id FROM special_customer)
    """
@SQLRestriction(CUSTOMER_FILTER)
```
- https://docs.jboss.org/hibernate/orm/6.6/javadocs/org/hibernate/annotations/SQLRestriction.html
- https://stackoverflow.com/questions/77178963/is-there-a-replacement-for-the-in-6-3-deprecated-where-and-loader
- https://docs.jboss.org/hibernate/stable/orm/javadocs/org/hibernate/annotations/Where.html
- https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/criterion/Restrictions.html
## @Immutable
### org.hibernate.annotations.Immutable
- https://www.baeldung.com/hibernate-immutable
- https://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/annotations/Immutable.html
- https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/annotations/Immutable.html
- https://stackoverflow.com/questions/1590422/what-is-the-difference-between-immutable-and-entitymutable-false-when-using
