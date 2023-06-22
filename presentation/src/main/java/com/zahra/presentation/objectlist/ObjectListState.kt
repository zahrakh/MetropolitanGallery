package com.zahra.presentation.objectlist


data class ObjectListState(
    val isLoading: Boolean = false,
    val isError: Boolean=false,
    val objectList: List<Int>? = null
)