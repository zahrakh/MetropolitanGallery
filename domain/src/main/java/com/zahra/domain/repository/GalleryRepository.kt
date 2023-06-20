package com.zahra.domain.repository

import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.ObjectsIds
import com.zahra.domain.data.common.Either

interface GalleryRepository {
    suspend fun getObjectsByName(objectName: String?): Either<ObjectsIds?, String>
    suspend fun getObjectDetailsById(objectID: Int?): Either<MuseumObjectDetails?, String>
}