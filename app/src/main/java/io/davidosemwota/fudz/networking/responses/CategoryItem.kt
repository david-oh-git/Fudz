package io.davidosemwota.fudz.networking.responses

import androidx.annotation.Keep

@Keep
data class CategoryItem(
    val id: String?,
    val name: String?,
    val primary: Boolean?
)