package com.zahra.presentation.objectdetails

import com.zahra.domain.data.MuseumObjectDetails

data class ObjectDetailsState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val model: MuseumObjectDetails? = null,
)