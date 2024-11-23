package com.acme.hibernate6issue.product.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository: JpaRepository<ProductEntity, UUID> {
}
