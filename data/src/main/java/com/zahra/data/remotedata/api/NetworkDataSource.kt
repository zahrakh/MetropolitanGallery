package com.zahra.data.remotedata.api

import com.zahra.data.remotedata.dto.ObjectsDetailsDto
import com.zahra.data.remotedata.dto.ObjectsDto
import com.zahra.domain.data.common.Either

interface NetworkDataSource {
    suspend fun getObjectsByName(objectName: String?): Either<ObjectsDto?, String>
    suspend fun getObjectDetailsById(objectID: Int?): Either<ObjectsDetailsDto?, String>
}