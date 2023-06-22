package com.zahra.data.remotedata

import com.google.common.truth.Truth.assertThat
import com.zahra.data.R
import com.zahra.data.StringProvider
import com.zahra.data.remotedata.api.ApiService
import com.zahra.data.remotedata.api.NetworkDataSource
import com.zahra.data.remotedata.api.NetworkDataSourceImp
import com.zahra.data.remotedata.dto.ObjectsDetailsDto
import com.zahra.data.remotedata.dto.ObjectsDto
import com.zahra.domain.data.common.Either
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.HttpException

class NetworkDataSourceImpTest {

    private lateinit var apiService: ApiService
    private lateinit var networkDataSource: NetworkDataSource
    private lateinit var stringProvider: StringProvider

    @Before
    fun setUp() {
        apiService = Mockito.mock(ApiService::class.java)
        stringProvider = Mockito.mock(StringProvider::class.java)
        networkDataSource = NetworkDataSourceImp(apiService, stringProvider)
    }

    @Test
    fun `test http exception in get Objets`(): Unit = runBlocking {
        val queryName = "SunFlower"
        val exception = Mockito.mock(HttpException::class.java)
        Mockito.`when`(exception.message).thenReturn("Http test message")
        Mockito.`when`(
            apiService.getObjectsByName(queryName)
        ).thenThrow(exception)

        val result: Either<ObjectsDto?, String> = networkDataSource.getObjectsByName(
            queryName
        )
        assertThat(result).isInstanceOf(Either.Error::class.java)
        val error = result as Either.Error
        assertThat(error.error).isEqualTo("Http test message")
    }


    @Test
    fun `test exception in get object details when http message is null`(): Unit =
        runBlocking {
            val objectId=470824
            val exception = Mockito.mock(HttpException::class.java)
            Mockito.`when`(exception.message).thenReturn(null)
            Mockito.`when`(apiService.getObjectDetailsById(objectId))
                .thenThrow(exception)

            Mockito.`when`(stringProvider.getString(R.string.error_occurred))
                .thenReturn("Unfortunately, an error has occurred")
            val result: Either<ObjectsDetailsDto?, String> =
                networkDataSource.getObjectDetailsById(objectId)
            assertThat(result).isInstanceOf(Either.Error::class.java)
            val error = result as Either.Error
            assertThat(error.error).isEqualTo("Unfortunately, an error has occurred")
        }

}

