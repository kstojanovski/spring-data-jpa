package com.acme.jpaspec.person.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
internal interface PersonRepository : JpaRepository<PersonEntity, UUID>, JpaSpecificationExecutor<PersonEntity> {

    /**
     * Query Method
     */
    fun findAllByOrderByIdAsc(): MutableList<PersonEntity>

    /**
     * Native query with the keyword WITH at the beginning
     */
    @Query(
        """
            with
            lastNameQuery as (
                select last_name from person where last_name = :lastName
            )
            select * from person where first_name = :firstName and last_name = (select last_name from lastNameQuery)
        """,
        nativeQuery = true
    )
    fun findBySubSelects(firstName: String, lastName: String): List<PersonEntity>

}

