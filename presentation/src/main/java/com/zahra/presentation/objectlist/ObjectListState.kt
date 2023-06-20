package com.zahra.presentation.objectlist


data class ObjectListState(
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val objectList: List<Int>? = null
)