package com.acme.hibernate6issue.product

import com.acme.hibernate6issue.product.persistence.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(val productRepository: ProductRepository) {
}
