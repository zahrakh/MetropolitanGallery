package com.zahra.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.zahra.presentation.R

@Composable
fun CoilImageView(
    url: String,
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .placeholder(R.drawable.poster_placeholder)
        .error(R.drawable.poster_placeholder)
        .build()

    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(url).build(),
            imageLoader = imageLoader
        ),
        contentDescription = stringResource(id = R.string.desc_logo),

        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Gray, CircleShape)
    )


}