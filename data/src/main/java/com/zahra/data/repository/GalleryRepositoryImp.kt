package com.zahra.data.repository

import com.zahra.data.remotedata.api.NetworkDataSource
import com.zahra.domain.data.Departments
import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.ObjectsIds
import com.zahra.domain.data.common.Either
import com.zahra.domain.repository.GalleryRepository
import javax.inject.Inject

class GalleryRepositoryImp @Inject constructor(
    private val networkDataSource: NetworkDataSource
) : GalleryRepository {
    override suspend fun getDepartmentList(): Either<Departments?, String> {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectsByCollectionId(departmentId: Int): Either<ObjectsIds, String> {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectsBySearch(objectName: String?): Either<ObjectsIds, String> {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectDetailsById(objectID: String?): Either<MuseumObjectDetails, String> {
        TODO("Not yet implemented")
    }

}