package com.zahra.presentation.objectdetails.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.zahra.domain.data.MuseumObjectDetails


@Composable
fun ObjectInfoScreen(
    model: MuseumObjectDetails? = null,
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
) {

}


@Preview
@Composable
private fun MonsterTitleWithSubtitlePreview() {
    ObjectInfoScreen(
        MuseumObjectDetails()
    )
}
