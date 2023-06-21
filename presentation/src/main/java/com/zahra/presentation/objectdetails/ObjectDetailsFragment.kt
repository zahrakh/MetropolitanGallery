package com.zahra.presentation.objectdetails

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zahra.presentation.ui.component.TopBar

@Composable
fun ObjectDetailsFragment(
    viewModel: ObjectDetailsViewModel = hiltViewModel(),
    objectId: Int,
    onNavigateUp: () -> Unit
) {
    val screenState by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) { viewModel.getObjectDetails(objectId) }
    Scaffold(
        topBar = {
            TopBar(onNavigateUp)
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            item {  }

        }
    }
}