package com.acme.hibernate6issue.product

import com.acme.hibernate6issue.product.persistence.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class ProductController(val productRepository: ProductRepository) {

    @GetMapping
    fun getHelloWorld() = "Hello World!"

}
