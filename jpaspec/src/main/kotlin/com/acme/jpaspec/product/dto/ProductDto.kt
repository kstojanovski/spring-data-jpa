package com.acme.jpaspec.product.dto

import java.util.*

internal data class ProductDto (
    val id: UUID,
    val productNumber: UUID,
    val name: String,
    val description: String
)