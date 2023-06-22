package com.zahra.presentation.objectlist.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zahra.presentation.R
import com.zahra.presentation.ui.theme.MetropolitanGalleryTheme

@Composable
fun ObjectLazyListScreen(
    modifier: Modifier = Modifier,
    objectList: List<Int>? = null,
    navigateToDetailsPage: (Int) -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        if (!objectList.isNullOrEmpty()) {
            ObjectList(
                list = objectList,
                onItemClicked = navigateToDetailsPage
            )
        }
    }
}


@Composable
fun ObjectList(
    list: List<Int> = arrayListOf(),
    onItemClicked: (item: Int) -> Unit = { },
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(list) { item ->
            Card(
                modifier = Modifier
                    .border(1.dp, color = colorResource(id = R.color.card_background))
                    .clickable {
                        onItemClicked(item)
                    }
            ) {
                Text(
                    text = item.toString(),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MetropolitanGalleryTheme() {
        ObjectLazyListScreen()
    }
}



