package io.davidosemwota.fudz.networking.responses

import androidx.annotation.Keep

@Keep
data class ResponseAddress(
    val label: String?,
    val countryCode: String?,
    val countryName: String?,
    val stateCode: String?,
    val state: String?,
    val countyCode: String?,
    val county: String?,
    val city: String?,
    val district: String?,
    val street: String?,
    val postalCode: String?,
    val houseNumber: String?
)