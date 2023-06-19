package com.zahra.presentation.explorelist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ObjectListFragment(
    modifier: Modifier = Modifier,
    viewModel: ObjectListViewModel = hiltViewModel(),
    onClickToDetailScreen: () -> Unit = {},
) {

    val screenState by viewModel.state.collectAsStateWithLifecycle()

}