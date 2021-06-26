package io.davidosemwota.fudz.storage

import kotlinx.coroutines.flow.Flow

interface FudzDataSource {

    suspend fun getRestaurants(latLng: String): List<Restaurant>

    suspend fun getRestaurants(): Flow<List<Restaurant>>

    suspend fun clearDatabase()

    suspend fun save(restaurant: Restaurant)
}