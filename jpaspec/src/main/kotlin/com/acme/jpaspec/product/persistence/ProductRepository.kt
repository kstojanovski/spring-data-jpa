package com.acme.jpaspec.product.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
internal interface ProductRepository : JpaRepository<ProductEntity<*>, UUID> {

//    @Suppress("UNCHECKED_CAST")
//    fun saveCasualProduct(entity: ProductEntity<CasualExtraInformation>) : ProductEntity<CasualExtraInformation> {
//        return save(entity as ProductEntity<*>) as ProductEntity<CasualExtraInformation>
//    }

//    fun saveCasualProduct(entity: ProductEntity<CasualExtraInformation>): ProductEntity<CasualExtraInformation> {
//        return save(entity)
//    }

    @Query(
        """SELECT id, product_number, name, description, extra_information as "dummy"
           FROM product""",
        nativeQuery = true
    )
    fun findAllForOverview(): List<ProductEntity<*>>

    @Query(
        """SELECT *
           FROM product
           WHERE product_type = :productType AND id = :id""",
        nativeQuery = true
    )
    fun findCasualProduct(
        id: UUID, productType: ProductTypeEnum = ProductTypeEnum.CASUAL
    ): ProductEntity<CasualExtraInformation>

    @Query(
        """SELECT *
           FROM product
        WHERE product_type = :#{#productTypeEnum.key}""",
        nativeQuery = true
    )
    fun findAllCasualProducts(
        productTypeEnum: ProductTypeEnum = ProductTypeEnum.CASUAL
    ): List<ProductEntity<CasualExtraInformation>>

}