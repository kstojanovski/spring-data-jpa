package com.acme.jpaspec.product.dto

import java.util.UUID

internal data class CasualExtraInformationDto(
    val casualId: UUID,
    val casualDescription: String,
    val height: Int,
    val length: Int,
    val width: Int,
)