package com.acme.jpaspec.product.persistence

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

enum class ProductTypeEnum(val key: String) {
    CASUAL("my_casual");

        override fun toString(): String {
        return key
    }

    @Converter(autoApply = true)
    internal class ProductTypeEnumConverter : AttributeConverter<ProductTypeEnum, String> {
        override fun convertToDatabaseColumn(addressTypeEnum: ProductTypeEnum): String {
            return addressTypeEnum.toString()
        }

        override fun convertToEntityAttribute(string: String): ProductTypeEnum {
            return entries.first { it.key == string }
        }
    }
}