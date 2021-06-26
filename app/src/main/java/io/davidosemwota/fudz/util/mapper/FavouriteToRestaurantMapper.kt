package io.davidosemwota.fudz.util.mapper

import io.davidosemwota.fudz.storage.Restaurant
import io.davidosemwota.fudz.storage.local.FavouriteRestaurant

class FavouriteToRestaurantMapper : Mapper<FavouriteRestaurant, Restaurant> {

    override suspend fun transform(from: FavouriteRestaurant): Restaurant {
        return Restaurant(
            district = from.district,
            name = from.name,
            street = from.street,
            city = from.city,
            houseNumber = from.houseNumber,
            isOpen = from.isOpen,
            openingHours = from.openingHours,
            phones = from.phones,
            webSites = from.webSites,
            lng = from.lng,
            lat = from.lat
        )
    }
}