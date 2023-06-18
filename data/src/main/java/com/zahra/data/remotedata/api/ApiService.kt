package com.zahra.data.remotedata.api

import com.zahra.data.remotedata.dto.DepartmentsDto
import com.zahra.data.remotedata.dto.ObjectsDetailsDto
import com.zahra.data.remotedata.dto.ObjectsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val BASE_URL = "https://collectionapi.metmuseum.org/"
    }

    @GET("public/collection/v1/departments")
    suspend fun getDepartments(): DepartmentsDto

    @GET("public/collection/v1/objects?departmentId={id}")
    suspend fun getObjectsById(
        @Path("id") departmentId: Int,
    ): ObjectsDto

    @GET("public/collection/v1/search?q={parameter}")
    suspend fun getObjectsByName(
        @Path("parameter") searchParam: String?,
    ): ObjectsDto

    @GET("public/collection/v1/objects/{id}")
    suspend fun getObjectDetailsById(
        @Path("id") objectID: String?,
    ): ObjectsDetailsDto
}






