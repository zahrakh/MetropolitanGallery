package com.zahra.presentation.explorelist.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zahra.presentation.ui.component.EmptyView
import com.zahra.presentation.ui.theme.MetropolitanGalleryTheme

@Composable
fun LazyListScreen(
    modifier: Modifier = Modifier,
    objectList: List<Int>? = null,
    onClickToDetailScreen: (Int) -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        if (!objectList.isNullOrEmpty()) {
            ObjectList(list = objectList) { id ->
                onClickToDetailScreen(id)
            }
        } else {
            EmptyView(visible = objectList.isNullOrEmpty())
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
            Text(
                text = item.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(4.dp))
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center,

                )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MetropolitanGalleryTheme() {
        LazyListScreen()
    }
}



