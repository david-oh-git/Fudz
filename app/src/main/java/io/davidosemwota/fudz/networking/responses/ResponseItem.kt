package io.davidosemwota.fudz.networking.responses

import androidx.annotation.Keep

@Keep
data class ResponseItem(
    val title: String?,
    val id: String?,
    val ontologyId: String?,
    val resultType: String?,
    val address: ResponseAddress?,
    val position: ResponsePosition?,
    val access: List<ResponsePosition>?,
    val distance: Int?,
    val categories: List<CategoryItem>?,
    val references: List<Reference>?,
    val foodTypes: List<CategoryItem>?,
    val contacts: List<ContactsItem>?,
    val openingHours: List<OpeningHour>?,
)

@Keep
data class HereResponse(
    val items: List<ResponseItem>?
)