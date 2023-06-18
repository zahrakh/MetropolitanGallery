package com.zahra.data.remotedata.api

import com.zahra.data.R
import com.zahra.data.StringProvider
import com.zahra.data.remotedata.dto.DepartmentsDto
import com.zahra.data.remotedata.dto.ObjectsDetailsDto
import com.zahra.data.remotedata.dto.ObjectsDto
import com.zahra.domain.data.common.Either
import retrofit2.HttpException
import java.io.IOException

class NetworkDataSourceImp constructor(
    private val service: ApiService,
    private val stringProvider: StringProvider
) : NetworkDataSource {
    override suspend fun getDepartments(): Either<DepartmentsDto?, String> {
        return try {
            val resultDto = service.getDepartments()
            Either.Success(resultDto)
        } catch (e: HttpException) {//Todo create Error Handler for Network
            Either.Error(error = e.message ?: stringProvider.getString(R.string.error_occurred))
        } catch (e: IOException) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.check_internet_connection))
        } catch (e: Exception) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.unknown_error))
        }
    }

    override suspend fun getObjectsById(departmentId: Int): Either<ObjectsDto?, String> {
        return try {
            val resultDto = service.getObjectsById(departmentId)
            Either.Success(resultDto)
        } catch (e: HttpException) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.error_occurred))
        } catch (e: IOException) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.check_internet_connection))
        } catch (e: Exception) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.unknown_error))
        }
    }

    override suspend fun getObjectsByName(objectName: String?): Either<ObjectsDto?, String> {
        return try {
            val resultDto = service.getObjectsByName(objectName)
            Either.Success(resultDto)
        } catch (e: HttpException) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.error_occurred))
        } catch (e: IOException) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.check_internet_connection))
        } catch (e: Exception) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.unknown_error))
        }
    }

    override suspend fun getObjectDetailsById(objectID: String?): Either<ObjectsDetailsDto?, String> {
        return try {
            val resultDto = service.getObjectDetailsById(objectID)
            Either.Success(resultDto)
        } catch (e: HttpException) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.error_occurred))
        } catch (e: IOException) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.check_internet_connection))
        } catch (e: Exception) {
            Either.Error(error = e.message ?: stringProvider.getString(R.string.unknown_error))
        }
    }

}