package com.zahra.presentation.objectdetails.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.presentation.R


@Composable
fun ObjectInfoScreen(
    model: MuseumObjectDetails? = null,
) = Column(
    verticalArrangement = Arrangement.spacedBy(1.dp),
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(color = Color.White)
) {
    val modifier = Modifier.padding(
        start = 24.dp,
        top = 8.dp,
    )
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.department_name),
            color = Color.LightGray,
            fontSize = 16.sp,
        )
        Text(
            text = model?.department ?: "",
            color = Color.Black,
            fontSize = 16.sp,
        )
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.object_country),
            color = Color.LightGray,
            fontSize = 16.sp,
        )
        Text(
            text = model?.country ?: "",
            color = Color.Black,
            fontSize = 16.sp,
        )
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.object_location),
            color = Color.LightGray,
            fontSize = 16.sp,
        )
        Text(
            text = model?.repository ?: "",
            color = Color.Black,
            fontSize = 16.sp,
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    model?.additionalImages?.let { additionalImages ->
        if (additionalImages.isNotEmpty()) {
            Text(
                modifier = modifier,
                text = stringResource(id = R.string.more_Image),
                color = Color.DarkGray,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow {
                items(additionalImages) { item ->
                    AsyncImage(
                        contentDescription = "additional image",
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(item)
                            .scale(Scale.FIT)
                            .placeholder(R.drawable.poster_placeholder)
                            .error(R.drawable.poster_placeholder)
                            .crossfade(true)
                            .build(),
                        modifier = Modifier
                            .background(
                                shape = RoundedCornerShape(8.dp),
                                color = colorResource(
                                    id =R.color.card_background
                                ),
                            )
                            .padding(8.dp)
                            .width(100.dp)
                            .height(100.dp)

                    )
                }
            }
        }
    }

}


@Preview
@Composable
private fun MonsterTitleWithSubtitlePreview() {
    ObjectInfoScreen(
        MuseumObjectDetails()
    )
}
