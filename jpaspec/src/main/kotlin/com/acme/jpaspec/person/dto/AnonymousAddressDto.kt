package com.acme.jpaspec.person.dto

import com.acme.jpaspec.person.persistence.AddressEntity
import com.acme.jpaspec.person.persistence.AddressTypeEnum
import java.util.UUID

internal class AnonymousAddressDto(
    val type: AddressTypeEnum,
    val street: String,
    val houseNumber: String,
    val postalCode: String,
    val city: String,
    val country: String,
)

internal fun AnonymousAddressDto.toAddressEntity(id: UUID) = AddressEntity(
    id = id,
    type = type,
    street = street,
    houseNumber = houseNumber,
    postalCode = postalCode,
    city = city,
    country = country
)