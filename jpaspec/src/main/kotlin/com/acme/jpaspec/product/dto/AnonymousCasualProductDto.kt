package com.acme.jpaspec.product.dto

import java.util.UUID

internal data class AnonymousCasualProductDto(
    val productNumber: UUID,
    val name: String,
    val description: String,
    val casualId: UUID,
    val casualDescription: String,
    val height: Int,
    val length: Int,
    val width: Int,
)