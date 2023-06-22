package com.zahra.presentation.objectlist

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.data.common.Either
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetObjectsByNameUseCase
import com.zahra.presentation.R
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
    private val getObjectsByNameUseCase: GetObjectsByNameUseCase,
    private val dispatcherProvider: DispatcherProvider,
) : ViewModel() {

    private val _state: MutableStateFlow<ObjectListState> = MutableStateFlow(ObjectListState())
    val state = _state.asStateFlow()

    private val _searchText = MutableStateFlow("")
    private val searchText = _searchText.asStateFlow()

    private var job: Job? = null

    fun onSearchTextChange(text: String) {
        _searchText.value = text
        if (text.isEmpty()) {
            _state.value = _state.value.copy(
                objectList = null,
            )
            return
        }
        job?.cancel()
        job = viewModelScope.launch(dispatcherProvider.io()) {

            _state.value = _state.value.copy(isLoading = true)

            _searchText.debounce(500).collect { query ->

                when (val result = getObjectsByNameUseCase.invoke(query)) {
                    is Either.Success -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            objectList = result.data?.objectIDs,
                        )
                    }

                    is Either.Error -> {
                        Log.i("ErrorLog 1", result.error)
                        _state.value = _state.value.copy(
                            isLoading = false,
                            errorMessage = result.error,
                        )

                    }
                }
            }
        }
    }


}