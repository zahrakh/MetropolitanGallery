package com.zahra.presentation.ui.animation

import androidx.compose.animation.*
import androidx.compose.runtime.Composable

@Composable
fun FadeInScreen(
    visible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    return AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) { content() }
}