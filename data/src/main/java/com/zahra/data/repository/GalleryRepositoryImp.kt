package com.zahra.data.repository

import com.zahra.data.remotedata.api.NetworkDataSource
import com.zahra.domain.repository.GalleryRepository
import javax.inject.Inject

class GalleryRepositoryImp @Inject constructor(
    private val networkDataSource: NetworkDataSource
) : GalleryRepository {
}