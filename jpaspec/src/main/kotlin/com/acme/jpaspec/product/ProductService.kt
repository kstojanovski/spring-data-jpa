package com.acme.jpaspec.product

import com.acme.jpaspec.product.dto.AnonymousCasualProductDto
import com.acme.jpaspec.product.dto.CasualExtraInformationDto
import com.acme.jpaspec.product.dto.CasualProductDto
import com.acme.jpaspec.product.dto.ProductDto
import com.acme.jpaspec.product.persistence.CasualExtraInformation
import com.acme.jpaspec.product.persistence.ProductEntity
import com.acme.jpaspec.product.persistence.ProductRepository
import com.github.f4b6a3.uuid.alt.GUID
import org.springframework.stereotype.Service
import java.util.UUID

@Service
internal class ProductService(private val productRepository: ProductRepository) {

//    fun saveCasualProduct(anonymousCasualProductDto: AnonymousCasualProductDto): ProductEntity<CasualExtraInformation> {
//        return productRepository.saveCasualProduct(
//            ProductEntity(
//                id = GUID.v7().toUUID(),
//                productNumber = anonymousCasualProductDto.productNumber,
//                name = anonymousCasualProductDto.name,
//                description = anonymousCasualProductDto.description,
//                extraInformation = CasualExtraInformation(
//                    casualId = anonymousCasualProductDto.casualId,
//                    casualDescription = anonymousCasualProductDto.casualDescription,
//                    height = anonymousCasualProductDto.height,
//                    length = anonymousCasualProductDto.length,
//                    width = anonymousCasualProductDto.width
//                )
//            )
//        )
//    }

    fun findAllForOverview(): List<ProductDto> {
        return productRepository.findAllForOverview()
            .map {
                ProductDto(
                    id = it.id,
                    productNumber = it.productNumber,
                    name = it.name,
                    description = it.description
                )
            }
    }

    fun findAllCasualProduct(id: UUID): CasualProductDto {
        val casualProductEntity = productRepository.findCasualProduct(id)
        val extraInformation = casualProductEntity.extraInformation
        return CasualProductDto(
            id = casualProductEntity.id,
            productNumber = casualProductEntity.productNumber,
            name = casualProductEntity.name,
            description = casualProductEntity.description,
            casualExtraInformationDto = CasualExtraInformationDto(
                casualId = extraInformation.casualId,
                casualDescription = extraInformation.casualDescription,
                height = extraInformation.height,
                length = extraInformation.length,
                width = extraInformation.width
            )

        )
    }

}