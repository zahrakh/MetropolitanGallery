package com.zahra.domain.usecase


import com.google.common.truth.Truth.assertThat
import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.common.Either
import com.zahra.domain.repository.GalleryRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class GetObjectDetailsByIdUseCaseImpTest {

    private lateinit var getObjectDetailsByIdUseCase: GetObjectDetailsByIdUseCase
    private lateinit var galleryRepository: GalleryRepository


    @Before
    fun setUp() {
        galleryRepository = Mockito.mock(GalleryRepository::class.java)
        getObjectDetailsByIdUseCase = GetObjectDetailsByIdUseCaseImp(galleryRepository)
    }

    @Test
    fun test(): Unit = runBlocking {
        `when`(galleryRepository.getObjectDetailsById(45678))
            .thenReturn(
                Either.Success(
                    MuseumObjectDetails(
                        objectID = 436524,
                        accessionYear = "1993",
                        primaryImage = "https://images.metmuseum.org/CRDImages/ad/original/174423.jpg",
                        department = "The American Wing",
                        additionalImages = arrayListOf(
                            "https://images.metmuseum.org/CRDImages/ad/original/174423.jpg",
                            "https://images.metmuseum.org/CRDImages/ad/original/174423.jpg",
                            "https://images.metmuseum.org/CRDImages/ad/original/174423.jpg",
                            "https://images.metmuseum.org/CRDImages/ad/original/174423.jpg"
                        )
                    )
                )
            )

        val result: Either<MuseumObjectDetails?, String> = getObjectDetailsByIdUseCase(45678)
        assertThat(result).isInstanceOf(Either.Success::class.java)
        val data: MuseumObjectDetails? = (result as Either.Success).data
        assertThat(data?.additionalImages).hasSize(4)
        assertThat(data?.objectID).isEqualTo(436524)
    }

}