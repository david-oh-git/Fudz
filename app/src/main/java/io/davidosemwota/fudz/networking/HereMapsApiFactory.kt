package io.davidosemwota.fudz.networking

import io.davidosemwota.fudz.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HereMapsApiFactory {

    private const val hereMapsBaseUrl = "https://discover.search.hereapi.com/v1/"

    /**
     *  Provider method for [HttpLoggingInterceptor] for HTTP client
     *
     *  @return Instance of http interceptor
     */
    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    /**
     *  Provides instance of [OkHttpClient]
     *
     *  @return Instance of http client
     */
    private fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(interceptor)
        }
        return clientBuilder.build()
    }

    /**
     * Provider method for Here Maps [Retrofit]
     *
     * @return Instance of retrofit
     */
    private fun provideRetrofitBuilder() =
        Retrofit.Builder()
            .baseUrl(hereMapsBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideHttpClient(provideHttpLoggingInterceptor()))
            .build()

    fun provideHereMapsService(): HereMapsService =
        provideRetrofitBuilder().create(HereMapsService::class.java)
}