package com.acme.hibernate6issue.product.persistence

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "product")
@SqlResultSetMapping(
    name = "ProductRowMapper",
    classes = [ConstructorResult(
        targetClass = ProductRow::class,
        columns = arrayOf(
            ColumnResult(name = "productIdentification"),
            ColumnResult(name = "productName"),
            ColumnResult(name = "productDescription"),
            ColumnResult(name = "productCreationDate"),
            ColumnResult(name = "productUpdateDate")
        )
    )]
)
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(name = "product_identification")
    val productIdentification: UUID,

    @Column(name = "product_name")
    val productName: String,

    @Column(name = "product_description")
    val productDescription: String,

    @Column(name = "product_creation_date", columnDefinition = "TIMESTAMP")
    val productCreationDate: Date,

    @Column(name = "product_update_date", columnDefinition = "TIMESTAMP")
    val productUpdateDate: Date) {
}

data class ProductRow (
    val productIdentification: UUID,
    val productName: String,
    val productDescription: String,
    val productCreationDate: Date,
    val productUpdateDate: Date)