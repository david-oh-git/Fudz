package io.davidosemwota.fudz.domain

import io.davidosemwota.fudz.storage.FudzRepository

class ClearDatabaseUsecase(
    private val repository: FudzRepository
) {

    suspend fun execute() {
        repository.clearDatabase()
    }
}