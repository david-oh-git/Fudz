package io.davidosemwota.fudz.storage.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [FavouriteRestaurant::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FudzDatabase : RoomDatabase() {

    abstract fun favouriteRestaurantDao(): FavouriteRestaurantDao
}