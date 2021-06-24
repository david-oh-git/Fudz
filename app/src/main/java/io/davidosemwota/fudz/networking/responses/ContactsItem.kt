package io.davidosemwota.fudz.networking.responses

import androidx.annotation.Keep


@Keep
class ContactsItem(
    val phone: List<Contact>?,
    val www: List<Contact>?
)

@Keep
data class Contact(
    val value: String,
    val categories: List<Id>?
)

@Keep
data class Id(
    val id: String?
)