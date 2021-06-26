package io.davidosemwota.fudz.domain

import io.davidosemwota.fudz.storage.FudzRepository
import io.davidosemwota.fudz.storage.Restaurant
import kotlinx.coroutines.flow.Flow

class FavouriteRestaurants(
    private val repository: FudzRepository
) {

    suspend fun execute(): Flow<List<Restaurant>> {
        return repository.getFavouriteRestaurants()
    }
}