package com.zahra.domain.usecase


import com.zahra.domain.repository.GalleryRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class GetObjectsByNameUseCaseImpTest {

    private lateinit var getObjectsByNameUseCase: GetObjectsByNameUseCase
    private lateinit var galleryRepository: GalleryRepository

    @Before
    fun setUp() {
        galleryRepository = Mockito.mock(GalleryRepository::class.java)
        getObjectsByNameUseCase = GetObjectsByNameUseCaseImp(galleryRepository)
    }

    @Test
    fun `test useCase must call gallery repository`(): Unit = runBlocking {
        getObjectsByNameUseCase.invoke("sun")
        verify(galleryRepository, times(1)).getObjectsByName("sun")
    }

}