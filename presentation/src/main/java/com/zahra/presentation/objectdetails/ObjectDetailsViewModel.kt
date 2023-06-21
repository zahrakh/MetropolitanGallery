package com.zahra.presentation.objectdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.data.common.Either
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetObjectDetailsByIdUseCase
import com.zahra.presentation.objectdetails.screen.DetailsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ObjectDetailsViewModel @Inject constructor(
    private val getObjectDetailsByIdUseCase: GetObjectDetailsByIdUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _state: MutableStateFlow<DetailsScreenState> =
        MutableStateFlow(DetailsScreenState())
    val state = _state.asStateFlow()

    var job: Job? = null

    fun getObjectDetails(id: Int) {
        job?.cancel()
        job = viewModelScope.launch(dispatcherProvider.io()) {
            _state.value = _state.value.copy(
                isLoading = true,
                objectDetails = null,
                errorMessage = null
            )
            when (val result = getObjectDetailsByIdUseCase.invoke(id)) {
                is Either.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        objectDetails = result.data,
                        errorMessage = null
                    )
                }

                is Either.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        objectDetails = null,
                        errorMessage = result.error
                    )
                }

            }
        }
    }

}