package io.davidosemwota.fudz.domain

import io.davidosemwota.fudz.storage.FudzRepository
import io.davidosemwota.fudz.storage.Restaurant

class SaveRestaurantUseCase(
    private val repository: FudzRepository
) {

    suspend fun execute(restaurant: Restaurant) {
        repository.save(restaurant)
    }
}