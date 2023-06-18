package com.zahra.data.remotedata.api

import com.zahra.data.StringProvider
import com.zahra.data.remotedata.dto.DepartmentsDto
import com.zahra.data.remotedata.dto.ObjectsDetailsDto
import com.zahra.data.remotedata.dto.ObjectsDto
import com.zahra.domain.data.common.Either

class NetworkDataSourceImp constructor(
    private val apiService: ApiService,
    private val stringProvider: StringProvider
) : NetworkDataSource {
    override suspend fun getDepartments(): Either<DepartmentsDto?, String> {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectsById(departmentId: Int): Either<ObjectsDto, String> {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectsByName(objectName: String?): Either<ObjectsDto, String> {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectDetailsById(objectID: String?): Either<ObjectsDetailsDto, String> {
        TODO("Not yet implemented")
    }

}