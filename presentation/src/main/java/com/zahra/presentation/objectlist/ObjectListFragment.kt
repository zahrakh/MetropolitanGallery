package com.zahra.presentation.objectlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zahra.presentation.objectlist.screen.ObjectLazyListScreen
import com.zahra.presentation.ui.component.ErrorView
import com.zahra.presentation.ui.component.ProgressView
import com.zahra.presentation.ui.component.SearchView
import kotlinx.coroutines.FlowPreview

@OptIn(FlowPreview::class)
@Composable
fun ObjectListFragment(
    viewModel: ObjectListViewModel = hiltViewModel(),
    navigateToDetailsPage: (Int) -> Unit,
) {
    val screenState by viewModel.state.collectAsStateWithLifecycle()
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        topBar = {
            SearchView(
                textState,
                viewModel::onSearchTextChange
            )
        },
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Column {
                ObjectLazyListScreen(
                    modifier = Modifier,
                    objectList = screenState.objectList,
                    navigateToDetailsPage = navigateToDetailsPage,
                )
                ProgressView(
                    screenState.isLoading
                )
                ErrorView(
                    errorMessage = screenState.errorMessage ?: "",
                    ocClick = { viewModel.onRetry() },
                    visible = screenState.errorMessage != null,
                )
            }
        }
    }
}