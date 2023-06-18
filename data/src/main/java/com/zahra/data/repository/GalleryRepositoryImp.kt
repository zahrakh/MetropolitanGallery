package com.zahra.data.repository

import com.zahra.data.remotedata.api.NetworkDataSource
import com.zahra.data.remotedata.dto.toDepartmentList
import com.zahra.data.remotedata.dto.toObjectDetails
import com.zahra.data.remotedata.dto.toObjectIds
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
        return when (val result = networkDataSource.getDepartments()) {
            is Either.Success -> {
                Either.Success(result.data?.toDepartmentList())
            }

            is Either.Error -> {
                Either.Error(result.error)
            }
        }
    }

    override suspend fun getObjectsById(departmentId: Int): Either<ObjectsIds?, String> {
        return when (val result = networkDataSource.getObjectsById(departmentId)) {
            is Either.Success -> {
                Either.Success(result.data?.toObjectIds())
            }

            is Either.Error -> {
                Either.Error(result.error)
            }
        }
    }

    override suspend fun getObjectsByName(objectName: String?): Either<ObjectsIds?, String> {
        return when (val result = networkDataSource.getObjectsByName(objectName)) {
            is Either.Success -> {
                Either.Success(result.data?.toObjectIds())
            }

            is Either.Error -> {
                Either.Error(result.error)
            }
        }
    }

    override suspend fun getObjectDetailsById(objectID: Int?): Either<MuseumObjectDetails?, String> {
        return when (val result = networkDataSource.getObjectDetailsById(objectID)) {
            is Either.Success -> {
                Either.Success(result.data?.toObjectDetails())
            }

            is Either.Error -> {
                Either.Error(result.error)
            }
        }
    }

}