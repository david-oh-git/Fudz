package io.davidosemwota.fudz.storage

data class Restaurant(
    val name: String,
    val houseNumber: String,
    val street: String,
    val district: String,
    val city: String,
    val lat: Double,
    val lng: Double,
    val phones: List<String>,
    val webSites: List<String>,
    val openingHours: String,
    val isOpen: Boolean
)