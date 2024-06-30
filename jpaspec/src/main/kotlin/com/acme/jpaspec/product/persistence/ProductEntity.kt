package com.acme.jpaspec.product.persistence

import com.github.f4b6a3.uuid.alt.GUID
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType
import jakarta.persistence.*
import org.hibernate.annotations.Type
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.util.*

@Entity
@Table(name = "product")
internal class ProductEntity<EI : ExtraInformation> (
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID = GUID.v7().toUUID(),
    @Column(name = "product_number", nullable = true)
    val productNumber: UUID,
    @Column(name = "product_type", nullable = false)
    val productType: ProductTypeEnum,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "description", nullable = false)
    val description: String,
    @Type(JsonBinaryType::class)
    @Column(name = "extra_information", nullable = true, columnDefinition = "jsonb")
    val extraInformation: EI,
) {
    @Version
    @Column(nullable = false)
    val version: Int = 1

    @CreatedDate
    @Column(nullable = false)
    val createdDate: Instant = Instant.now()

    @CreatedBy
    @Column(nullable = false)
    val createdBy: String = "trusted user"

    @LastModifiedDate
    @Column(nullable = false)
    val lastModifiedDate: Instant = Instant.now()

    @LastModifiedBy
    @Column(nullable = false)
    val lastModifiedBy: String = "trusted user"
}