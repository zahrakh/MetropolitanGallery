package com.zahra.presentation.objectlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.data.common.Either
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetObjectsByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
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

    fun onSearchTextChange(text: String) {
        _searchText.value = text

        if (text.isEmpty()) {
            _state.value = _state.value.copy(
                objectList = null,
            )
            return
        }

        viewModelScope.launch(dispatcherProvider.io()) {

            _state.value = _state.value.copy(isLoading = true)

            searchText.debounce(2000).collect { query ->

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
                            isError = true,
                        )

                    }
                }
            }
        }
    }


}