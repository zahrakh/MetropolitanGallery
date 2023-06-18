package com.zahra.domain.repository

import com.zahra.domain.data.Departments
import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.ObjectsIds
import com.zahra.domain.data.common.Either

interface GalleryRepository {
    suspend fun getDepartmentList(): Either<Departments?, String>
    suspend fun getObjectsByCollectionId(departmentId: Int): Either<ObjectsIds, String>
    suspend fun getObjectsBySearch(objectName: String?): Either<ObjectsIds, String>
    suspend fun getObjectDetailsById(objectID: String?): Either<MuseumObjectDetails, String>
}