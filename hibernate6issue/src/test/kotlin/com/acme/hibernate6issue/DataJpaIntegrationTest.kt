package com.acme.hibernate6issue

import com.acme.hibernate6issue.product.persistence.ProductEntity
import com.acme.hibernate6issue.product.persistence.ProductRepository
import com.acme.hibernate6issue.product.persistence.ProductSearchRepository
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Import
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.*

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ProductSearchRepository::class)
class DataJpaIntegrationTest {

    val log: Logger = LoggerFactory.getLogger(DataJpaIntegrationTest::class.java)

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var productSearchRepository: ProductSearchRepository

    @Autowired
    lateinit var entityManager: EntityManager

    companion object {
        @JvmStatic
        @Container
        @ServiceConnection
        val postgres = PostgreSQLContainer<Nothing>("postgres:latest")
    }

    @Test
    fun connection() {
        assertThat(postgres.isCreated).isTrue()
        assertThat(postgres.isRunning).isTrue()
    }

    @Test
    fun `test the CRUD`() {
        //Arrange
        val productEntity = ProductEntity(
            id = null,
            productIdentification = UUID.randomUUID(),
            productName = "test",
            productDescription = "description",
            productCreationDate = Date.from(Instant.now()),
            productUpdateDate = Date.from(Instant.now())
        )
        productRepository.save(productEntity)

        //Act
        val allProducts = productRepository.findAll()

        //Assert
        assertThat(allProducts).hasSize(1)
    }

    @Test
    fun `reproduce the by-day-problem`() {
        //Arrange
        val productEntity = ProductEntity(
            id = null,
            productIdentification = UUID.randomUUID(),
            productName = "test",
            productDescription = "description",
            productCreationDate = Date.from(Instant.now()),
            productUpdateDate = Date.from(Instant.now())
        )
        productRepository.save(productEntity)

        // extract(DAY FROM :startTime-p.productCreationDate) > 1
        //Act
        val productEntityTypedQuery = entityManager.createQuery(
            """
                    SELECT NEW com.acme.hibernate6issue.product.persistence.ProductEntity(
                        p.id,
                        p.productIdentification,
                        p.productName,
                        p.productDescription,
                        p.productCreationDate,
                        p.productUpdateDate
                    )
                    FROM ProductEntity p
                    WHERE
                    (
                        (p.productCreationDate - :startTime) by day > 1 
                    )
                """.trimIndent(),
            ProductEntity::class.java
        ).apply {
            setParameter(
                "startTime",
                Date.from(Instant.now()
                    .minus(2, ChronoUnit.DAYS)
                    .minus(1, ChronoUnit.SECONDS))
            )
            setMaxResults(10)
        }

        val now = Instant.now()
        val toString = now.atZone(ZoneId.systemDefault()).toString()
        log.info("now: {}", toString)
        val minus = now.minus(1, ChronoUnit.DAYS)
        log.info("nowMinus {}", minus.atZone(ZoneId.systemDefault()).toString())

        log.info("{}", Duration.between(now, minus).toDays().toString())
        log.info("{}", Duration.between(minus, now).toDays().toString())

        val allProducts = productEntityTypedQuery.resultList

        //Assert
        assertThat(allProducts).hasSize(1)
    }


    @Test
    fun `test the custom mapping vie create native query `() {
        //Arrange
        productRepository.saveAndFlush(ProductEntity(
            id = null,
            productIdentification = UUID.randomUUID(),
            productName = "test",
            productDescription = "description",
            productCreationDate = Date.from(Instant.now()),
            productUpdateDate = Date.from(Instant.now())
        ))
        productRepository.saveAndFlush(ProductEntity(
            id = null,
            productIdentification = UUID.randomUUID(),
            productName = "test",
            productDescription = "description",
            productCreationDate = Date.from(Instant.now()),
            productUpdateDate = Date.from(Instant.now())
        ))

        //Act
        val allProducts = productSearchRepository.getAllProductsByConstructorResult()
        //Assert
        assertThat(allProducts).hasSize(2)

        //Act
        val allProductsByT = productSearchRepository.getAllProductsByTupleClass()
        //Assert
        assertThat(allProductsByT).hasSize(2)

        //Act
        val allProductsByRt = productSearchRepository.getAllProductsByResultTransformer()
        //Assert
        assertThat(allProductsByRt).hasSize(2)

    }
}
