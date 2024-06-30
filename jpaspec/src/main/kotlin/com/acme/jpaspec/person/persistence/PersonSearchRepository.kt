package com.acme.jpaspec.person.persistence

import com.acme.jpaspec.person.dto.PersonSearchCriteriaDto
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
internal class PersonSearchRepository(private val personRepository: PersonRepository) {
    /**
     * Criteria API
     */
    fun search(dto: PersonSearchCriteriaDto, pageable: Pageable): Page<PersonEntity> {
        val specification = Specification
            .where(MatcherStringSpec("firstName", dto.firstName))
            .and(MatcherStringSpec("lastName", dto.lastName))
        return personRepository.findAll(specification, pageable)
    }
}

internal class MatcherStringSpec(private val field: String, private val value: String?) : Specification<PersonEntity> {
    override fun toPredicate(
        root: Root<PersonEntity>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {
        if (value.isNullOrBlank()) return null

        if (value.contains(",")) {
//            https://www.baeldung.com/jpa-criteria-api-in-expressions
//            val inClause: CriteriaBuilder.In<String> = criteriaBuilder.`in`(root[field])
//            val predicate = inClause.`in`(value.split(","))
//            return predicate

            //val predicate = root.get(field).`in`(value.split(","))
//            val predicate = root.get<List<String>>(field).`in`(value.split(",").map { it.trim() })
//            return predicate
            return root.get<List<String>>(field).`in`(value.split(",").map { it.trim() })
        }

        return criteriaBuilder.like(root.get(field), value)
    }
}

internal class MatcherDateSpec(
    private val field: String,
    private val inputFrom: Instant?,
    private val inputTo: Instant?
) : Specification<PersonEntity> {
    override fun toPredicate(
        root: Root<PersonEntity>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {
        if (inputFrom == null && inputTo == null) return null
        val from = inputFrom ?: Instant.EPOCH
        val to = inputFrom ?: Instant.MAX
        return criteriaBuilder.between(root.get<Instant>(field), from, to)
    }
}

internal class MatcherInSpec(
    private val field: String,
    private val inData: List<AddressTypeEnum>?
) : Specification<PersonEntity> {
    override fun toPredicate(
        root: Root<PersonEntity>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {
        if (inData.isNullOrEmpty()) return null

        val inClause: CriteriaBuilder.In<AddressTypeEnum> = criteriaBuilder.`in`(root[field])
        return inClause.`in`(inData)
    }

}
