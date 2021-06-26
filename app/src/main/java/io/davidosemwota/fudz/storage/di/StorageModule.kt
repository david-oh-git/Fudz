package io.davidosemwota.fudz.storage.di

import io.davidosemwota.fudz.networking.HereMapsApiFactory
import io.davidosemwota.fudz.networking.responses.ResponseItem
import io.davidosemwota.fudz.storage.FudzDataSource
import io.davidosemwota.fudz.storage.Restaurant
import io.davidosemwota.fudz.storage.remote.RemoteDataSource
import io.davidosemwota.fudz.util.mapper.Mapper
import io.davidosemwota.fudz.util.mapper.ResponseItemToRestaurantMapper
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val RESPONSE_RESTAURANT_QUALIFIER = "response_item_to_restaurant"
private const val REMOTE_DATA_QUALIFIER = "remote_data_source"

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
}