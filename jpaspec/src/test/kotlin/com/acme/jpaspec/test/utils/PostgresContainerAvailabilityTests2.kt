package com.acme.jpaspec.test.utils

import com.acme.jpaspec.product.persistence.CasualExtraInformation
import com.acme.jpaspec.product.persistence.ProductEntity
import com.acme.jpaspec.product.persistence.ProductRepository
import com.acme.jpaspec.product.persistence.ProductTypeEnum
import com.github.f4b6a3.uuid.alt.GUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class PostgresContainerAvailabilityTests2(
    @Autowired private val productRepository: ProductRepository
) {
    companion object {
        val db = PostgreSQLContainer("postgres")

        @BeforeAll
        @JvmStatic
        fun startDBContainer() {
            db.start()
        }

        @AfterAll
        @JvmStatic
        fun stopDBContainer() {
            db.stop()
        }

        @DynamicPropertySource
        @JvmStatic
        fun registerDBContainer(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", db::getJdbcUrl)
            registry.add("spring.datasource.username", db::getUsername)
            registry.add("spring.datasource.password", db::getPassword)
        }
    }

    @Test
    fun `dbContainer is running`() {
        Assertions.assertTrue(db.isRunning)
    }

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