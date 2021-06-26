package io.davidosemwota.fudz.storage.remote

import io.davidosemwota.fudz.networking.HereMapsService
import io.davidosemwota.fudz.networking.responses.ResponseItem
import io.davidosemwota.fudz.networking.responses.Result
import io.davidosemwota.fudz.storage.FudzDataSource
import io.davidosemwota.fudz.storage.Restaurant
import io.davidosemwota.fudz.util.mapper.Mapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber

class RemoteDataSource (
    private val restaurantMapper: Mapper<ResponseItem, Restaurant>,
    private val hereMapsService: HereMapsService,
    private val ioDispatcher: CoroutineDispatcher
) : FudzDataSource {

    override suspend fun getRestaurants(latLng: String): List<Restaurant> = withContext(ioDispatcher) {
        val apiResponse = safeApiCall(
            call = { hereMapsService.getRestaurants(latLng) } ,
            errorMsg = "Error fetching data .."
        )
        return@withContext apiResponse?.items?.map { restaurantMapper.transform(it) } ?: emptyList()
    }

    private suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>,
        errorMsg: String
    ): T? {

        val result: Result<T> = safeApiResult(call, errorMsg)
        var data: T? = null

        when (result) {
            is Result.Success -> data = result.data
            is Result.Error -> {
                Timber.d("Error !!! : $errorMsg")
            }
        }

        return data
    }

    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>,
        errorMsg: String
    ): Result<T> {

        try {
            val response = call.invoke()
            if (response.isSuccessful) return Result.Success(response.body()!!)

            return Result.Error(
                Exception("Error occurred while getting safe api result, ERROR - $errorMsg")
            )
        } catch (e: Exception) {
            return Result.Error(
                Exception("Error occurred while getting safe api result, ERROR - $errorMsg")
            )
        }
    }

    override suspend fun getFavouriteRestaurants(): Flow<List<Restaurant>> {
        TODO("Not yet implemented")
    }

    override suspend fun clearDatabase() {
        TODO("Not yet implemented")
    }

    override suspend fun save(restaurant: Restaurant) {
        TODO("Not yet implemented")
    }
}