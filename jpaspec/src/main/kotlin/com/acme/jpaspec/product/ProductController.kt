package com.acme.jpaspec.product

import com.acme.jpaspec.product.dto.AnonymousCasualProductDto
import com.acme.jpaspec.product.persistence.CasualExtraInformation
import com.acme.jpaspec.product.persistence.ProductEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/product")
internal class ProductController(val productService: ProductService) {

//    @PostMapping("/casual")
//    fun saveCasualProduct(@RequestBody casualProductDto: AnonymousCasualProductDto) {
//        productService.saveCasualProduct(casualProductDto)
//    }

//    @GetMapping("/casual/{id}")
//    fun findAllCasualProduct(@PathVariable id: UUID): ProductEntity<CasualExtraInformation> {
//        return productService.findAllCasualProduct(id)
//    }

}