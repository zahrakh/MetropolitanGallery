package com.zahra.presentation.objectdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zahra.presentation.objectdetails.screen.ObjectHeaderScreen
import com.zahra.presentation.objectdetails.screen.ObjectInfoScreen
import com.zahra.presentation.ui.component.ProgressView

@Composable
fun ObjectDetailsFragment(
    viewModel: ObjectDetailsViewModel = hiltViewModel(), objectId: Int, onNavigateUp: () -> Unit
) {
    val screenState by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) { viewModel.getObjectDetails(objectId) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        ProgressView(screenState.isLoading)

        LazyColumn {
            item {
                ObjectHeaderScreen(
                    screenState.model?.primaryImage, screenState.model?.objectName, onNavigateUp
                )
            }
            item {
                ObjectInfoScreen(model = screenState.model)
            }
        }
    }
}