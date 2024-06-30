package com.acme.jpaspec.person.service

import com.acme.jpaspec.person.dto.AnonymousPersonDto
import com.acme.jpaspec.person.dto.PersonDto
import com.acme.jpaspec.person.persistence.PersonEntity
import com.acme.jpaspec.person.persistence.PersonRepository
import com.acme.jpaspec.person.persistence.toPersonDto
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
internal class PersonService(private val personRepository: PersonRepository) {

    @Transactional
    fun select(id: UUID): PersonDto {
        val personEntity: PersonEntity = (personRepository.findByIdOrNull(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND))
        return personEntity.toPersonDto()
    }

    @Transactional
    fun insert(anonymousPersonDto: AnonymousPersonDto): PersonDto {
        return personRepository.save(anonymousPersonDto.toNewEntity()).toPersonDto()
    }

    @Transactional
    fun update(id: UUID, anonymousPersonDto: AnonymousPersonDto): PersonDto {
        return personRepository.save(anonymousPersonDto.toEntity(select(id)))
            .toPersonDto()
    }

    @Transactional
    fun delete(id: UUID) {
        personRepository.deleteById(select(id).id)
    }
}
