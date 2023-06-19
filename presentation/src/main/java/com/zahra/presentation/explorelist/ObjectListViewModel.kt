package com.zahra.presentation.explorelist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetDepartmentListUseCase
import com.zahra.domain.usecase.GetObjectsByIdUseCase
import com.zahra.domain.usecase.GetObjectsByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

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
            _searchText.debounce(1000).collect { query ->
                Log.i("LOGX", System.currentTimeMillis().toString() + ":   query:$query")
            }
        }
    }

}