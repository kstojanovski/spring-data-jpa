package com.acme.jpaspec.person.persistence

import com.acme.jpaspec.person.dto.PersonDto
import com.github.f4b6a3.uuid.alt.GUID
import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.util.*

@Entity
@Table(name = "person")
internal class PersonEntity(
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID = GUID.v7().toUUID(),
    @Column(name = "first_name", nullable = false)
    val firstName: String,
    @Column(name = "last_name", nullable = false)
    val lastName: String,
    @Column(name = "age", nullable = true)
    val age: Int?,
    @OneToMany
//    @Column(name = "address", nullable = true)
    @JoinColumn(name = "address", nullable = true)
    val addresses: List<AddressEntity>,
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

internal fun PersonEntity.toPersonDto() = PersonDto(
    id = id,
    firstName = firstName,
    lastName = lastName,
    age = age,
    addresses = addresses.map { it.toAddressDto() }
)