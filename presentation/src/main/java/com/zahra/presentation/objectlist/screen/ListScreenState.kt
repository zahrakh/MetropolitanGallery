package com.zahra.presentation.objectlist.screen


data class ListScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val objectList: List<Int>? = null
)