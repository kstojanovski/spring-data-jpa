package com.acme.jpaspec.product.dto

import java.util.*

internal data class CasualProductDto (
    val id: UUID,
    val productNumber: UUID,
    val name: String,
    val description: String,
    val casualExtraInformationDto: CasualExtraInformationDto
)