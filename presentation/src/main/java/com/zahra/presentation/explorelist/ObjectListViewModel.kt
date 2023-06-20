package com.zahra.presentation.explorelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.data.common.Either
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetDepartmentListUseCase
import com.zahra.domain.usecase.GetObjectsByIdUseCase
import com.zahra.domain.usecase.GetObjectsByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@FlowPreview
@HiltViewModel
class ObjectListViewModel @Inject constructor(
    private val getDepartmentsUseCase: GetDepartmentListUseCase,
    private val getObjectsByNameUseCase: GetObjectsByNameUseCase,
    private val getObjectsByIdUseCase: GetObjectsByIdUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _state: MutableStateFlow<ObjectListState> = MutableStateFlow(ObjectListState())
    val state = _state.asStateFlow()

    private val _searchText = MutableStateFlow("")
    private val searchText = _searchText.asStateFlow()

    var job: Job? = null

    fun onSearchTextChange(text: String) {
        _searchText.value = text
        job?.cancel()
        job = viewModelScope.launch(dispatcherProvider.io()) {
            _searchText.debounce(
                1000
            ).collect { query ->
                when (val result = getObjectsByNameUseCase.invoke(query)) {
                    is Either.Success -> {
                        _state.value = _state.value.copy(
                            objectList = result.data?.objectIDs,
                            isLoading = false
                        )
                    }

                    is Either.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            errorMessage = result.error,
                            objectList = null
                        )
                    }
                }
            }
        }
    }

    fun onRetry() {

    }

}