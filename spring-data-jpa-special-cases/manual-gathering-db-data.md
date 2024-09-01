# Manual gathering database data
## Problem description
The data should be fetched from many tables that are related to each other in a unorthodox way, because the structure is
complex to the fetching process from logical or technical perspective. 
## Example
This is only an artificially examples where for the approach demonstration. The example here is very simple based on few
entities.
## Entities
### Entity Main
```
@Entity
@Table(name = "table_main")
internal class MainEntity(
    @Id
    @Column(name = "relation_id", updatable = false, nullable = false)
    val relationId: String,    
    @Column(name = "name", updatable = false, nullable = false)
    val name: String,
    @OneToMany(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "relation_id", nullable = false, updatable = false)
    val sub1s: MutableSet<Sub1Entity>,
    @OneToMany(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "relation_id", nullable = false, updatable = false)
    val sub2s: MutableSet<Sub2Entity>,
)
```
### Entity Sub1
```
@Entity
@Table(name = "table_sub1")
internal class Sub1Entity(
@Id
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID = UuidCreator.getTimeOrderedEpoch()
    @Column(name = "name", updatable = false, nullable = false)
    val name: String
    @Column(name = "relation_id", insertable = false, updatable = false, nullable = false)
    var relationId: String
)
```
### Entity Sub2
```
@Entity
@Table(name = "table_sub2")
internal class Sub2Entity(
@Id
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID = UuidCreator.getTimeOrderedEpoch()
    @Column(name = "name", updatable = false, nullable = false)
    val name: String
    @Column(name = "relation_id", insertable = false, updatable = false, nullable = false)
    var relationId: String
)
```
## Repository
```
internal interface MainRepository : JpaRepository<MainEntity, String>, CustomMainRepository {
    fun findByRelationId(relationId: String): MainEntity?
    fun fetchFullMainEntiry(relationId: String): IBSCustomerEntity? {
        return findByRelationId(relationId)?.let { preInitializeCustomer(it) }
    }
}
internal interface CustomMainRepository {
    fun preInitializeCustomer(mainEntity: MainEntity): MainEntity
}
internal class CustomMainRepositoryImpl(
    private val em: EntityManager
) : CustomMainRepository {

    override fun preInitializeCustomer(mainEntity: MainEntity): MainEntity {
        em.detach(relationId)
        val relationId = mainEntity.relationId
        
        val sub1s = em.createNativeQuery("select * from table_sub1 where relation_id = :relationId ", Sub1Entity::class.java).setParameter("relationId", relationId).resultList as MutableList<Sub1Entity>).toMutableSet()
        detachEntityElements(sub1s)
        val sub2s = em.createNativeQuery("select * from table_sub2 where relation_id = :relationId ", Sub2Entity::class.java).setParameter("relationId", relationId).resultList as MutableList<Sub2Entity>).toMutableSet()
        detachEntityElements(sub2s)
        
        return MainEntity(
            relationId = relationId,
            name = mainEntity.name,
            sub1s = sub1s,
            sub2s = sub2s 
        )
    }
    
    // is this sufficient or do the result or collection need to be explicitly referenced and returned? 
    private fun detachEntityElements(entities: Collection<*>) {
        for (entity in entities) {
            em.detach(entity)
        }
    }

}
```
