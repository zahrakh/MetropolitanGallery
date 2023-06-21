package com.zahra.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.presentation.R


@Composable
fun TopBar(onBackClicked: () -> Unit = {}) {
    TopAppBar(
        title = {
            Text(
                stringResource(R.string.page_title),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp
                )
            )
        },
        backgroundColor = Color.DarkGray,
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .clickable {
                        onBackClicked()
                    },
                contentDescription = "Action icon",
                tint = Color.White
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}