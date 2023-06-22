package com.zahra.presentation.viewmodel

import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.common.Either
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetObjectDetailsByIdUseCase
import com.zahra.presentation.objectdetails.ObjectDetailsViewModel
import com.zahra.presentation.util.MainDispatcherRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@OptIn(FlowPreview::class)
@RunWith(MockitoJUnitRunner::class)
class ObjectDetailsViewModelTest {

    private var getObjectDetailsByIdUseCase: GetObjectDetailsByIdUseCase = mock()
    private lateinit var mockDispatcher: DispatcherProvider
    private lateinit var detailsViewModel: ObjectDetailsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    val unconfinedDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val rule = MainDispatcherRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(unconfinedDispatcher)
        MockitoAnnotations.openMocks(this)
        mockDispatcher = object : DispatcherProvider {
            override fun io() = unconfinedDispatcher
            override fun main() = unconfinedDispatcher
            override fun default() = unconfinedDispatcher
            override fun unconfined() = unconfinedDispatcher
        }
        detailsViewModel = ObjectDetailsViewModel(getObjectDetailsByIdUseCase, mockDispatcher)
    }


    @Test
    fun `test get objects by name and check is success`() = runTest {
        val url="https://images.metmuseum.org/CRDImages/ad/original/174423.jpg"
        getObjectDetailsByIdUseCase.stub {
            onBlocking {
                invoke(123)
            }.doReturn(
                Either.Success<MuseumObjectDetails?, String>(
                    MuseumObjectDetails(
                        objectID = 436524,
                        accessionYear = "1993",
                        primaryImage = url,
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
        }

        detailsViewModel.getObjectDetails(123)
        val primaryImage = detailsViewModel.state.value.model?.primaryImage
        Assert.assertEquals(url, primaryImage)
    }



}