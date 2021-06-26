package io.davidosemwota.fudz.storage.local

import io.davidosemwota.fudz.storage.FudzDataSource
import io.davidosemwota.fudz.storage.Restaurant
import io.davidosemwota.fudz.util.mapper.Mapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val ioDispatcher: CoroutineDispatcher,
    private val favouriteToRestaurantMapper: Mapper<FavouriteRestaurant, Restaurant>,
    private val favouriteRestaurantDao: FavouriteRestaurantDao,
    private val restaurantToFavouriteMapper: Mapper<Restaurant, FavouriteRestaurant>
) : FudzDataSource {

    override suspend fun getRestaurants(latLng: String): List<Restaurant> {
        TODO("Not yet implemented")
    }

    override suspend fun getRestaurants(): Flow<List<Restaurant>> = withContext(ioDispatcher) {
        return@withContext favouriteRestaurantDao.getFavouritesRestaurants().map { listOfFavourites ->
            listOfFavourites.map { favouriteToRestaurantMapper.transform(it) }
        }
    }

    override suspend fun clearDatabase() = withContext(ioDispatcher) {
        favouriteRestaurantDao.clearDatabase()
    }

    override suspend fun save(restaurant: Restaurant) = withContext(ioDispatcher) {
        favouriteRestaurantDao.save(
            restaurantToFavouriteMapper.transform(restaurant)
        )
    }
}