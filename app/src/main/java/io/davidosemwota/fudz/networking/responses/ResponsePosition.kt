package io.davidosemwota.fudz.networking.responses

import androidx.annotation.Keep

@Keep
data class ResponsePosition(
    val lat: Double?,
    val lng: Double?
)