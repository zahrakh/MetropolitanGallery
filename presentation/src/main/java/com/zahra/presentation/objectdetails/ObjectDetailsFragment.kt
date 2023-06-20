package com.zahra.presentation.objectdetails

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ObjectDetailsFragment(
    viewModel: ObjectDetailsViewModel = hiltViewModel(),
    objectId: Int,
    onNavigateUp: () -> Unit
) {
    Text(
        text = objectId.toString(),
        Modifier.clickable {
            onNavigateUp()
        }
    )
}