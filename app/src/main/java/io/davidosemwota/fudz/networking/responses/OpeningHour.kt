package io.davidosemwota.fudz.networking.responses

import androidx.annotation.Keep

@Keep
data class OpeningHour(
    val categories: List<Id>?,
    val text: List<String>,
    val isOpen: Boolean?,
    val structured: List<Time>?
)

@Keep
data class Time(
    val start: String?,
    val duration: String?,
    val recurrence: String?
)