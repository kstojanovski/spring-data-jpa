package com.acme.jpaspec.person.service

import com.acme.jpaspec.person.dto.PersonDto
import com.acme.jpaspec.person.dto.PersonSearchCriteriaDto
import com.acme.jpaspec.person.persistence.PersonRepository
import com.acme.jpaspec.person.persistence.PersonSearchRepository
import com.acme.jpaspec.person.persistence.toPersonDto
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
internal class PersonSearchService(
    private val personSearchRepository: PersonSearchRepository,
    private val personRepository: PersonRepository
) {
    @Transactional
    fun selectAll(): List<PersonDto> {
        return personRepository.findAllByOrderByIdAsc()
            .map { it.toPersonDto() }
    }

    @Transactional
    fun findBySubSelects(firstName: String, lastName: String): List<PersonDto> {
        return personRepository.findBySubSelects(firstName, lastName)
            .map { it.toPersonDto() }
    }

    @Transactional
    fun search(personSearchCriteriaDto: PersonSearchCriteriaDto): Page<PersonDto> {
        return personSearchRepository.search(
            personSearchCriteriaDto,
            PageRequest.of(0, 10, Sort.DEFAULT_DIRECTION)
        ).map { it.toPersonDto() }
    }

}
