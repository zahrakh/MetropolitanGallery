package com.zahra.presentation.objectdetails.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zahra.domain.data.MuseumObjectDetails


@Composable
fun ObjectInfoScreen(
    model: MuseumObjectDetails? = null,
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
) {
    val contentPadding = PaddingValues(16.dp)
//    Column {
//        Text(
//            text = stringResource(id = R.string.object_name, model?.objectName ?: ""),
//            color = Color.DarkGray,
//            fontSize = 14.sp,
//            maxLines = 2,
//            modifier = Modifier.padding(
//                top = contentPadding.calculateTopPadding(),
//                start = contentPadding.calculateStartPadding(LayoutDirection.Rtl)
//            )
//        )
//
//        Text(
//            text = stringResource(id = R.string.department_name, model?.department ?: ""),
//            fontSize = 12.sp,
//            fontWeight = FontWeight.Light,
//            color = Color.DarkGray,
//            fontStyle = FontStyle.Normal,
//            maxLines = 1,
//            modifier = Modifier.padding(
//                bottom = contentPadding.calculateBottomPadding(),
//                start = contentPadding.calculateStartPadding(LayoutDirection.Rtl)
//            )
//        )
//    }
}


@Preview
@Composable
private fun MonsterTitleWithSubtitlePreview() {
    ObjectInfoScreen(
        MuseumObjectDetails()
    )
}
