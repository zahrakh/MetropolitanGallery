package com.zahra.presentation.objectdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zahra.presentation.objectdetails.screen.ObjectHeaderScreen
import com.zahra.presentation.objectdetails.screen.ObjectInfoScreen

@Composable
fun ObjectDetailsFragment(
    viewModel: ObjectDetailsViewModel = hiltViewModel(), objectId: Int, onNavigateUp: () -> Unit
) {
    val screenState by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) { viewModel.getObjectDetails(objectId) }
    Box {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                ObjectHeaderScreen(screenState.model?.primaryImage, onNavigateUp)
            }
            item {
                ObjectInfoScreen(model = screenState.model)
            }
        }
    }
}