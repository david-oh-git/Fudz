package io.davidosemwota.fudz.storage

interface FudzDataSource {

    suspend fun getRestaurants(latLng: String): List<Restaurant>
}