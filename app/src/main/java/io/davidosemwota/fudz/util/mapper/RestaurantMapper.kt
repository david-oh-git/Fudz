package io.davidosemwota.fudz.util.mapper

import io.davidosemwota.fudz.networking.responses.ResponseItem
import io.davidosemwota.fudz.storage.Restaurant

class RestaurantMapper : Mapper<ResponseItem, Restaurant> {

    override suspend fun transform(from: ResponseItem): Restaurant {
        val listOfOpeningHours = from.openingHours
        val isOpen: Boolean = if (listOfOpeningHours.isNullOrEmpty()){
            false
        }else {
            listOfOpeningHours[0].isOpen ?: false
        }

        val openingHours: String = if (listOfOpeningHours.isNullOrEmpty()){
            unknown
        }else {
            val text = listOfOpeningHours[0].text
            if (text.isNullOrEmpty())
                unknown
            else {
                text[0]
            }
        }

        val contacts = from.contacts
        val webSites: List<String> = if (contacts.isNullOrEmpty()){
            emptyList()
        }else {
           contacts.map { item -> item.www?.map { it.value } ?: emptyList() }.flatten()
        }
        val phones: List<String> = if (contacts.isNullOrEmpty()){
            emptyList()
        }else {
            contacts.map { item -> item.phone?.map { it.value } ?: emptyList() }.flatten()
        }

        return Restaurant(
            name = from.title ?: unknown,
            city = from.address?.city ?: unknown,
            district = from.address?.district ?: unknown,
            houseNumber = from.address?.houseNumber ?: unknown,
            lat = from.position?.lat ?: 0.0,
            lng = from.position?.lng ?: 0.0,
            openingHours = openingHours,
            isOpen = isOpen,
            phones = phones,
            street = from.address?.street ?: unknown,
            webSites = webSites
        )
    }

    companion object {
        const val unknown = "unknown"
    }
}