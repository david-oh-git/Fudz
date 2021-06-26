package io.davidosemwota.fudz.storage.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.davidosemwota.fudz.util.FAVOURITES_TABLE
import kotlinx.coroutines.flow.Flow

/**
 * Data access object for [FavouriteRestaurant].
 */
@Dao
interface FavouriteRestaurantDao {

    @Query("SELECT * FROM $FAVOURITES_TABLE ORDER BY id")
    fun getFavouritesRestaurants(): Flow<List<FavouriteRestaurant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(favouriteRestaurant: FavouriteRestaurant)

    @Query("DELETE FROM $FAVOURITES_TABLE")
    suspend fun clearDatabase()
}