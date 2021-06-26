package io.davidosemwota.fudz.presentation.home

import androidx.lifecycle.ViewModel
import io.davidosemwota.fudz.domain.ListOfRestaurantsUseCase

class HomeViewModel(
    private val listOfRestaurantsUseCase: ListOfRestaurantsUseCase
) : ViewModel() {
}