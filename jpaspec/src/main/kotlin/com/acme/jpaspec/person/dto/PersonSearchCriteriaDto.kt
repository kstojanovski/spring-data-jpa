package com.acme.jpaspec.person.dto

internal data class PersonSearchCriteriaDto(
    val firstName: String,
    val lastName: String,
)