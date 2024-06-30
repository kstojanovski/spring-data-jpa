package com.acme.jpaspec.product.persistence

import com.github.f4b6a3.uuid.alt.GUID
import java.util.UUID

internal data class CasualExtraInformation(
    val casualId: UUID = GUID.v7().toUUID(),
    val casualDescription: String,
    val height: Int,
    val length: Int,
    val width: Int,
) : ExtraInformation("casual-extra-information")