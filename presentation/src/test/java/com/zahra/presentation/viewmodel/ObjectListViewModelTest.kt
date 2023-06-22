package com.zahra.presentation.viewmodel

import com.zahra.domain.data.ObjectsIds
import com.zahra.domain.data.common.Either
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetObjectsByNameUseCase
import com.zahra.presentation.objectlist.ObjectListViewModel
import com.zahra.presentation.util.MainDispatcherRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
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
class ObjectListViewModelTest {

    private var getObjectsByNameUseCase: GetObjectsByNameUseCase = mock()
    private lateinit var mockDispatcher: DispatcherProvider
    private lateinit var listViewModel: ObjectListViewModel

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
        listViewModel = ObjectListViewModel(getObjectsByNameUseCase, mockDispatcher)
    }


    @Test
    fun `test get objects by name and check is success`() = runTest {
        getObjectsByNameUseCase.stub {
            onBlocking {
                invoke("Sun")
            }.doReturn(
                Either.Success<ObjectsIds?, String>(
                    ObjectsIds(
                        total = 10,
                        objectIDs = arrayListOf(1,2,3,4,5,6,7,8,9,0)
                    )
                )
            )
        }

        listViewModel.onSearchTextChange("Sun")
        delay(2000)//search time delay
        val resultSize = listViewModel.state.value.objectList?.size
        Assert.assertEquals(10, resultSize)
    }



}