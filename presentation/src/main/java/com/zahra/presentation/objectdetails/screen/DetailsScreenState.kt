package com.zahra.presentation.objectdetails.screen

import com.zahra.domain.data.MuseumObjectDetails

data class DetailsScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val objectDetails: MuseumObjectDetails? = null
)