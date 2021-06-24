package io.davidosemwota.fudz.networking.responses

import androidx.annotation.Keep

@Keep
class Reference(
    val id: String?,
    val supplier: Supplier
)

@Keep
data class Supplier(
    val id: String?
)