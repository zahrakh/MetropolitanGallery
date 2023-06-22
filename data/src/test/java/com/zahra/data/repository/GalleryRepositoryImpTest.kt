package com.zahra.data.repository


import com.google.common.truth.Truth.assertThat
import com.zahra.data.remotedata.api.NetworkDataSource
import com.zahra.data.remotedata.dto.ObjectsDetailsDto
import com.zahra.data.remotedata.dto.ObjectsDto
import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.ObjectsIds
import com.zahra.domain.data.common.Either
import com.zahra.domain.repository.GalleryRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class GalleryRepositoryImpTest {

    private lateinit var networkDataSource: NetworkDataSource
    private lateinit var repository: GalleryRepository

    @Before
    fun setUp() {
        networkDataSource = Mockito.mock(NetworkDataSource::class.java)
        repository = GalleryRepositoryImp(networkDataSource)
    }

    @Test
    fun `test get Objects by search name success `(): Unit = runBlocking {
        val queryName = "Sun Flower"
        `when`(networkDataSource.getObjectsByName(queryName))
            .thenReturn(
                Either.Success(
                    ObjectsDto(
                        total = 3,
                        objectIDs = getObjectList()
                    )
                )
            )

        val result = repository.getObjectsByName(queryName)
        assertThat(result).isInstanceOf(Either.Success::class.java)
        val success: Either.Success<ObjectsIds?, String> = result as Either.Success
        val data: ObjectsIds? = success.data
        assertThat(success.data?.objectIDs).hasSize(3)
        assertThat(data?.objectIDs?.get(0)).isEqualTo(436524)
    }


    @Test
    fun `test get Object details by id success `(): Unit = runBlocking {
        val objectId = 436524
        `when`(networkDataSource.getObjectDetailsById(objectId))
            .thenReturn(
                Either.Success(
                    ObjectsDetailsDto(
                        objectID=436524,
                                accessionYear="1993",
                                primaryImage="https://images.metmuseum.org/CRDImages/ad/original/174423.jpg",
                                department="The American Wing",
                    )
                )
            )

        val result = repository.getObjectDetailsById(objectId)
        assertThat(result).isInstanceOf(Either.Success::class.java)
        val success: Either.Success<MuseumObjectDetails?, String> = result as Either.Success
        val data: MuseumObjectDetails? = success.data
         assertThat(data?.accessionYear).isEqualTo("1993")
    }

    private fun getObjectList(): List<Int> {
        return listOf(
            436524,
            484935,
            437112,
        )
    }
}

