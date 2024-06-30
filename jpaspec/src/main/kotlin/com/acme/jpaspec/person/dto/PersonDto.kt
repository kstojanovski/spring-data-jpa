package com.acme.jpaspec.person.dto

import java.util.*

internal data class PersonDto (
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val age: Int?,
    val addresses: List<AddressDto>
)
