package com.acme.hibernate6issue.product.persistence

import jakarta.persistence.EntityManager
import jakarta.persistence.Tuple
import org.hibernate.query.Query
import org.hibernate.query.TupleTransformer
import org.springframework.stereotype.Service
import java.util.*


@Service
class ProductSearchRepository(
    private val entityManager: EntityManager
) {

    fun getAllProductsByResultTransformer(): List<ProductData> {
        val productRows: List<ProductRow> =
            entityManager
                .createNativeQuery(
                    """SELECT 
                        product_identification as productIdentification, 
                        product_name as productName, 
                        product_description as productDescription,
                        product_creation_date as productCreationDate,
                        product_update_date as productUpdateDate                        
                       FROM 
                        Product""".trimMargin()
                )
                .unwrap(Query::class.java)
                .setTupleTransformer(ProductRowTupleTransformer())
                .resultList as List<ProductRow>
        return productRows
            .map {
                ProductData(
                    productIdentification = it.productIdentification,
                    productName = it.productName,
                    productDescription = it.productDescription
                )
            }
    }

    fun getAllProductsByTupleClass(): List<ProductData> {
        val productRows: List<Tuple> =
            entityManager
                .createNativeQuery(
                    """SELECT 
                        product_identification as productIdentification, 
                        product_name as productName, 
                        product_description as productDescription,                        
                        product_creation_date as productCreationDate,
                        product_update_date as productUpdateDate
                       FROM 
                        Product""".trimMargin()
                    ,
                    Tuple::class.java
                )
                .resultList as List<Tuple>
        return productRows
            .map {
                ProductData(
                    productIdentification = it.get("productIdentification") as UUID,
                    productName = it.get("productName") as String,
                    productDescription = it.get("productDescription") as String
                )
            }
    }

    fun getAllProductsByConstructorResult(): List<ProductData> {
        val productRows: List<ProductRow> =
            entityManager
                .createNativeQuery(
                    """SELECT 
                        product_identification as productIdentification, 
                        product_name as productName, 
                        product_description as productDescription,
                        product_creation_date as productCreationDate,
                        product_update_date as productUpdateDate
                       FROM 
                        Product""".trimMargin()
                    ,
                    "ProductRowMapper"
                )
                .resultList as List<ProductRow>
        return productRows
            .map { 
                ProductData(
                    productIdentification = it.productIdentification,
                    productName = it.productName,
                    productDescription = it.productDescription
                )
            }
    }
}

data class ProductData (
    val productIdentification: UUID,
    val productName: String,
    val productDescription: String)

class ProductRowTupleTransformer: TupleTransformer<ProductRow> {
    override fun transformTuple(tuple: Array<out Any>, aliases: Array<out String>): ProductRow {
        return ProductRow(
            productIdentification = tuple[0] as UUID,
            productName = tuple[1] as String,
            productDescription = tuple[2] as String,
            productCreationDate = tuple[3] as Date,
            productUpdateDate = tuple[4] as Date
        )
    }
}