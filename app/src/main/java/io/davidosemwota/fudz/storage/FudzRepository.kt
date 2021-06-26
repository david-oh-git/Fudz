package io.davidosemwota.fudz.storage

import kotlinx.coroutines.flow.Flow

interface FudzRepository {

    suspend fun getRestaurants(latLng: String): List<Restaurant>

    suspend fun getFavouriteRestaurants(): Flow<List<Restaurant>>

    suspend fun clearDatabase()

    suspend fun save(restaurant: Restaurant)
}