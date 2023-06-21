package com.zahra.presentation.objectlist.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.presentation.ui.component.EmptyView
import com.zahra.presentation.ui.theme.MetropolitanGalleryTheme

@Composable
fun ObjectLazyListScreen(
    modifier: Modifier = Modifier,
    objectList: List<Int>? = null,
    navigateToDetailsPage: (Int) -> Unit = {},
 ) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        if (!objectList.isNullOrEmpty()) {
            ObjectList(
                list = objectList,
                onItemClicked = navigateToDetailsPage
            )
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
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                text = item.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClicked(item)
                    }
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
        ObjectLazyListScreen()
    }
}



