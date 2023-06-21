package com.zahra.presentation.objectlist


data class ObjectListState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val objectList: List<Int>? = null
)