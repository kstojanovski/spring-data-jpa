package com.acme.jpaspec.person.persistence

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

internal enum class AddressTypeEnum {
    PRIVATE, COMPANY;

//    override fun toString(): String {
//        return name.lowercase()
//    }
//
//    @Converter(autoApply = true)
//    internal class AddressTypeEnumConverter : AttributeConverter<AddressTypeEnum, String> {
//        override fun convertToDatabaseColumn(addressTypeEnum: AddressTypeEnum): String {
//            return addressTypeEnum.toString()
//        }
//
//        override fun convertToEntityAttribute(string: String): AddressTypeEnum {
//            return entries.first { it.name.lowercase() == string }
//        }
//    }

}