package com.zahra.data.remotedata.api

import com.zahra.data.remotedata.dto.CollectionResponseDto
import com.zahra.data.remotedata.dto.ObjectsDetailsDto
import com.zahra.data.remotedata.dto.ObjectsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val BASE_URL = "https://collectionapi.metmuseum.org/"
    }

    @GET("public/collection/v1/departments")
    suspend fun getCollections(): CollectionResponseDto

    @GET("public/collection/v1/objects?departmentId={id}")
    suspend fun getObjectsByCollectionId(
        @Path("id") departmentId: Int,
    ): ObjectsResponseDto

    @GET("public/collection/v1/search?q={parameter}")
    suspend fun getObjectsBySearch(
        @Path("parameter") searchParam: String?,
    ): ObjectsResponseDto

    @GET("public/collection/v1/objects/{id}")
    suspend fun getObjectDetails(
        @Path("id") objectID: String?,
    ): ObjectsDetailsDto
}






