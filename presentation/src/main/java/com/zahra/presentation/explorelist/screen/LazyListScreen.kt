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
import androidx.compose.material3.BottomAppBarDefaults.ContainerElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
    restaurantList: List<Int>? = null,
    onClickToDetailScreen: (Int) -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        if (!restaurantList.isNullOrEmpty()) {
            RestaurantList(restaurantList = restaurantList) { restaurantId ->
                onClickToDetailScreen(restaurantId)
            }
        } else {
            EmptyView(visible = restaurantList.isNullOrEmpty())
        }
    }
}


@Composable
fun RestaurantList(
    restaurantList: List<Int> = arrayListOf(),
    onItemClicked: (item: Int) -> Unit = { },
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(restaurantList) { item ->
            RestaurantItemRow(item = item, onItemClicked = onItemClicked)
        }
    }
}

@Composable
fun RestaurantItemRow(
    item: Int,
    onItemClicked: (clickedItem: Int) -> Unit = { },
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = ContainerElevation
        ),
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



