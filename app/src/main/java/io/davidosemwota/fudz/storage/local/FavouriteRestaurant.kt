package io.davidosemwota.fudz.storage.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.davidosemwota.fudz.util.FAVOURITES_TABLE

/**
 * Entity class representing a row on the database table.
 */
@Entity(
    tableName = FAVOURITES_TABLE
)
data class FavouriteRestaurant(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val houseNumber: String,
    @ColumnInfo val street: String,
    @ColumnInfo val district: String,
    @ColumnInfo val city: String,
    @ColumnInfo val lat: Double,
    @ColumnInfo val lng: Double,
    @ColumnInfo val phones: List<String>,
    @ColumnInfo val webSites: List<String>,
    @ColumnInfo val openingHours: String,
    @ColumnInfo val isOpen: Boolean
)
