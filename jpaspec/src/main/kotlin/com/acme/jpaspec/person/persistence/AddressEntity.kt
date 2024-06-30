package com.acme.jpaspec.person.persistence

import com.acme.jpaspec.person.dto.AddressDto
import com.github.f4b6a3.uuid.alt.GUID
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.util.*

@Entity
@Table(name = "address")
internal class AddressEntity(
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID = GUID.v7().toUUID(),
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    val type: AddressTypeEnum,
    @Column(name = "street", nullable = false)
    val street: String,
    @Column(name = "house_number", nullable = false)
    val houseNumber: String,
    @Column(name = "postalCode", nullable = false)
    val postalCode: String,
    @Column(name = "city", nullable = false)
    val city: String,
    @Column(name = "country", nullable = false)
    val country: String,
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

internal fun AddressEntity.toAddressDto() = AddressDto(
    id = id,
    type = type,
    street = street,
    houseNumber = houseNumber,
    postalCode = postalCode,
    city = city,
    country = country
)