package com.zahra.data.remotedata.api

import com.zahra.data.StringProvider

class NetworkDataSourceImp constructor(
    private val apiService: ApiService,
    private val stringProvider: StringProvider
) : NetworkDataSource {

}