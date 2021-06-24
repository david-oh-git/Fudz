package io.davidosemwota.fudz.networking

import io.davidosemwota.fudz.BuildConfig
import io.davidosemwota.fudz.networking.responses.HereResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HereMapsService {

    @GET(DISCOVER_ENDPOINT)
    suspend fun getRestaurants(
        @Query("at") latLng: String,
        @Query("q") query: String = "restaurants",
        @Query("apiKey") apiKey: String = BuildConfig.HERE_MAP_API_KEY
    ): Response<HereResponse>

    companion object {
        const val DISCOVER_ENDPOINT = "discover"
    }
}