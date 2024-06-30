package com.acme.jpaspec.person.dto

import com.acme.jpaspec.person.persistence.PersonEntity
import com.github.f4b6a3.uuid.alt.GUID

internal data class AnonymousPersonDto(
    val firstName: String,
    val lastName: String,
    val age: Int?,
    val anonymousAddresses: List<AnonymousAddressDto>
) {
    internal fun toNewEntity(): PersonEntity {
        return PersonEntity(
            id = GUID.v7().toUUID(),
            firstName = firstName,
            lastName = lastName,
            age = age,
            addresses = anonymousAddresses.map { it.toAddressEntity(GUID.v7().toUUID()) }
        )
    }

    internal fun toEntity(personDto: PersonDto) = PersonEntity(
        id = personDto.id,
        firstName = firstName,
        lastName = lastName,
        age = age,
        addresses = personDto.addresses.map { it.toAddressEntity() }
    )
}

