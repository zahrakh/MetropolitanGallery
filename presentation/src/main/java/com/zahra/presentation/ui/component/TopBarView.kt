package com.zahra.presentation.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zahra.presentation.R


@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(stringResource(R.string.page_title)) },
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                modifier = Modifier.padding(horizontal = 4.dp),
                contentDescription = "Action icon",
                tint = Color.Gray
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}