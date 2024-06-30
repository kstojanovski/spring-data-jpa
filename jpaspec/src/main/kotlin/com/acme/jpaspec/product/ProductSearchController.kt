package com.acme.jpaspec.product

import com.acme.jpaspec.product.dto.ProductDto
import com.acme.jpaspec.product.persistence.ProductEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
internal class ProductSearchController(val productService: ProductService) {

    @GetMapping("/casual")
    fun findAllForOverview(): List<ProductDto> {
        return productService.findAllForOverview()
    }

}