package com.zahra.presentation.explorelist.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            ObjectItemRow(item = item, onItemClicked = onItemClicked)
        }
    }
}

@Composable
fun ObjectItemRow(
    item: Int,
    onItemClicked: (clickedItem: Int) -> Unit = { },
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .clickable { onItemClicked(item) }) {
        Box() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
            }
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



