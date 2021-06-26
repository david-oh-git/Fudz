package io.davidosemwota.fudz.storage

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class DefaultRepository(
    private val ioDispatcher: CoroutineDispatcher,
    private val localSource: FudzDataSource,
    private val remoteSource: FudzDataSource
) : FudzRepository {

    override suspend fun getRestaurants(latLng: String): List<Restaurant> = 
        withContext(ioDispatcher){
        return@withContext remoteSource.getRestaurants(latLng)
    }

    override suspend fun getFavouriteRestaurants(): Flow<List<Restaurant>> = withContext(ioDispatcher) {
        return@withContext localSource.getFavouriteRestaurants()
    }

    override suspend fun clearDatabase() = withContext(ioDispatcher) {
        localSource.clearDatabase()
    }

    override suspend fun save(restaurant: Restaurant) = withContext(ioDispatcher) {
        localSource.save(restaurant)
    }
}