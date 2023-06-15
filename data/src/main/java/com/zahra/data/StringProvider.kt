package com.zahra.data

import androidx.annotation.StringRes

interface StringProvider {

    fun getString(@StringRes id: Int): String
}