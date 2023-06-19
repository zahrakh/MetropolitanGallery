package com.zahra.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zahra.presentation.R
import com.zahra.presentation.ui.animation.FadeInScreen

@Composable
fun EmptyView(
    visible: Boolean,
) {
    FadeInScreen(visible = visible) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = Color.Black,
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.no_objects_found)
            )
        }
    }
}
