package com.zahra.presentation.objectdetails.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
        start = 16.dp,
        top = 8.dp,
    )
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = stringResource(id = R.string.department_name),
            color = Color.LightGray,
            fontSize = 14.sp,
        )
        Text(
            text = model?.department ?: "",
            color = Color.Black,
            fontSize = 14.sp,
        )
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.object_country),
            color = Color.LightGray,
            fontSize = 14.sp,
        )
        Text(
            text = model?.country ?: "",
            color = Color.Black,
            fontSize = 14.sp,
        )
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.accession_year),
            color = Color.LightGray,
            fontSize = 14.sp,
        )
        Text(
            text = model?.accessionYear ?: "",
            color = Color.Black,
            fontSize = 14.sp,
        )
    }
    Spacer(modifier = Modifier.height(8.dp))

    model?.additionalImages?.let { additionalImages ->
        if (additionalImages.isNotEmpty()) {
            Text(
                modifier = modifier,
                text = stringResource(id = R.string.more_Image),
                color = colorResource(
                    id = R.color.card_background
                ),
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                modifier = modifier,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
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
                            .clip(RectangleShape)
                            .border(
                                1.dp,
                                color = colorResource(
                                    id = R.color.card_background
                                ),
                                RectangleShape
                            )
                            .width(100.dp)
                            .height(100.dp)

                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(100.dp))
}


@Preview
@Composable
private fun MonsterTitleWithSubtitlePreview() {
    ObjectInfoScreen(
        MuseumObjectDetails()
    )
}
