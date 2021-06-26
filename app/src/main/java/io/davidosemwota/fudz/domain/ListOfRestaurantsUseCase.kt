package io.davidosemwota.fudz.domain

import io.davidosemwota.fudz.storage.FudzRepository
import io.davidosemwota.fudz.storage.Restaurant

class ListOfRestaurantsUseCase(
    private val repository: FudzRepository
) {

    suspend fun execute(latLng: String): List<Restaurant> {
        return repository.getRestaurants(latLng)
    }
}