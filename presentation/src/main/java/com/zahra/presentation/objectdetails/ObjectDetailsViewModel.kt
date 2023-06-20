package com.zahra.presentation.objectdetails

import androidx.lifecycle.ViewModel
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetObjectDetailsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ObjectDetailsViewModel @Inject constructor(
    private val getObjectDetailsByIdUseCase: GetObjectDetailsByIdUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    fun getObjectDetails(id: Int) {

    }

}