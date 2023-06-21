package com.zahra.presentation.objectdetails

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun ObjectDetailsFragment(
    viewModel: ObjectDetailsViewModel = hiltViewModel(),
    objectId: Int,
    onNavigateUp: () -> Unit
) {
    val screenState by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) { viewModel.getObjectDetails(objectId) }

    Text(
        text = objectId.toString(),
        Modifier.clickable {
            onNavigateUp()
        }
    )
}