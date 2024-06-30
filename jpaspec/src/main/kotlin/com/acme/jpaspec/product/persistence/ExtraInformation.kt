package com.acme.jpaspec.product.persistence

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "extraInformation"
)
@JsonSubTypes(
    JsonSubTypes.Type(
        name = "casual-extra-information",
        value = CasualExtraInformation::class,
    ),
)
internal open class ExtraInformation(val extraInformation: String)