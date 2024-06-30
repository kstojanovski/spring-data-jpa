package com.acme.jpaspec.product

import com.acme.jpaspec.product.persistence.CasualExtraInformation
import com.acme.jpaspec.product.persistence.ProductEntity
import com.acme.jpaspec.product.persistence.ProductRepository
import com.acme.jpaspec.product.persistence.ProductTypeEnum
import com.acme.jpaspec.test.utils.DbIntegrationTest
import com.github.f4b6a3.uuid.alt.GUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class ProductDbIntegrationTest(
    @Autowired
    private var productRepository: ProductRepository
): DbIntegrationTest() {

    @Test
    fun `test the findAllCasualProduct method`() {
        productRepository.save(
            ProductEntity(
                productNumber = GUID.v7().toUUID(),
                name = "Alisha Brady",
                description = "detraxit",
                productType = ProductTypeEnum.CASUAL,
                extraInformation = CasualExtraInformation(
                    casualDescription = "voluptatum",
                    height = 2999,
                    length = 5101,
                    width = 4832
                )
            )
        )

        val allCasualProduct = productRepository.findAllCasualProducts()

        assertThat(allCasualProduct).isNotEmpty
        assertThat(allCasualProduct).hasSize(1)
    }
}