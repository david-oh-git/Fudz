package io.davidosemwota.fudz.storage.di

import android.content.Context
import androidx.room.Room
import io.davidosemwota.fudz.networking.HereMapsApiFactory
import io.davidosemwota.fudz.networking.responses.ResponseItem
import io.davidosemwota.fudz.storage.FudzDataSource
import io.davidosemwota.fudz.storage.Restaurant
import io.davidosemwota.fudz.storage.local.FavouriteRestaurant
import io.davidosemwota.fudz.storage.local.FavouriteRestaurantDao
import io.davidosemwota.fudz.storage.local.FudzDatabase
import io.davidosemwota.fudz.storage.local.LocalDataSource
import io.davidosemwota.fudz.storage.remote.RemoteDataSource
import io.davidosemwota.fudz.util.mapper.FavouriteToRestaurantMapper
import io.davidosemwota.fudz.util.mapper.Mapper
import io.davidosemwota.fudz.util.mapper.ResponseItemToRestaurantMapper
import io.davidosemwota.fudz.util.mapper.RestaurantToFavouriteMapper
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val RESPONSE_RESTAURANT_QUALIFIER = "response_item_to_restaurant"
private const val FAVOURITE_RESTAURANT_QUALIFIER = "favourite_to_restaurant"
private const val RESTAURANT_FAVOURITE_QUALIFIER = "restaurant_to_favourite"
private const val REMOTE_DATA_QUALIFIER = "remote_data_source"
private const val LOCAL_DATA_QUALIFIER = "local_data_source"

val storageModule = module {

    single { Dispatchers.IO }
    single { HereMapsApiFactory.provideHereMapsService() }
    single<Mapper<ResponseItem, Restaurant>>(named(RESPONSE_RESTAURANT_QUALIFIER)) {
        ResponseItemToRestaurantMapper()
    }
    single<FudzDataSource>(named(REMOTE_DATA_QUALIFIER)) {
        RemoteDataSource(
            get(named(RESPONSE_RESTAURANT_QUALIFIER)),
            get(),
            get()
        )
    }

    single { provideFavouriteRestaurantDao(androidContext()) }
    single<Mapper<FavouriteRestaurant, Restaurant>>(named(FAVOURITE_RESTAURANT_QUALIFIER)) {
        FavouriteToRestaurantMapper()
    }
    single<Mapper<Restaurant, FavouriteRestaurant>>(named(RESTAURANT_FAVOURITE_QUALIFIER)) {
        RestaurantToFavouriteMapper()
    }

    single<FudzDataSource>(named(LOCAL_DATA_QUALIFIER)) {
        LocalDataSource(
            get(),
            get(named(FAVOURITE_RESTAURANT_QUALIFIER)),
            get(),
            get(named(RESTAURANT_FAVOURITE_QUALIFIER))
        )
    }
}

private fun provideFavouriteRestaurantDao(context: Context): FavouriteRestaurantDao =
    Room.databaseBuilder(
        context.applicationContext,
        FudzDatabase::class.java,
        "favourites.db"
    ).build().favouriteRestaurantDao()