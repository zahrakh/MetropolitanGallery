package com.zahra.presentation.objectdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.data.common.Either
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetObjectDetailsByIdUseCase
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

    private val _state: MutableStateFlow<ObjectDetailsState> =
        MutableStateFlow(ObjectDetailsState())
    val state = _state.asStateFlow()

    var job: Job? = null

    fun getObjectDetails(id: Int) {
        job?.cancel()
        job = viewModelScope.launch(dispatcherProvider.io()) {
            _state.value = _state.value.copy(
                isLoading = true,
            )
            when (val result = getObjectDetailsByIdUseCase.invoke(id)) {
                is Either.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        model = result.data,
                        errorMessage = null
                    )
                }

                is Either.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        model = null,
                        errorMessage = result.error
                    )
                }
            }
        }
    }

    fun hideErrorDialog() {
        _state.value = _state.value.copy(errorMessage = null)
    }

    fun retry(id: Int) {
        getObjectDetails(id)
    }


}