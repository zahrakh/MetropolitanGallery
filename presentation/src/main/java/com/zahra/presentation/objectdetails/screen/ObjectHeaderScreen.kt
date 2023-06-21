package com.zahra.presentation.objectdetails.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zahra.presentation.R
import com.zahra.presentation.ui.component.CoilImageView

@Composable
fun ObjectHeaderScreen(
    objectImageUrl: String? = null,
    objectName: String? = null,
    onNavigateUp: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        val (image, info, topBar) = createRefs()

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(objectImageUrl)
                .placeholder(R.drawable.poster_placeholder)
                .error(R.drawable.poster_placeholder)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(id = R.string.image_poster),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .constrainAs(image) {
                    linkTo(
                        start = parent.start,
                        top = parent.top,
                        end = parent.end,
                        bottom = info.top,
                        bottomMargin = (-32).dp
                    )
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            contentScale = ContentScale.Crop
        )
        DetailsAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .constrainAs(topBar) {
                    linkTo(start = parent.start, end = parent.end)
                    top.linkTo(parent.top)
                    width = Dimension.fillToConstraints
                }
        ) { onNavigateUp() }
        val contentPadding = PaddingValues(16.dp)
        Surface(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier
                .constrainAs(info) {
                    linkTo(start = parent.start, end = parent.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(80.dp)
                }
        ) {
            Row {
                Column(
                    modifier = Modifier.padding(
                        top = contentPadding.calculateTopPadding(),
                        start = contentPadding.calculateStartPadding(LayoutDirection.Rtl)
                    )
                ) {
                    CoilImageView(
                        url = objectImageUrl ?: ""
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = stringResource(id = R.string.object_name),
                            color = Color.LightGray,
                            fontSize = 16.sp,
                        )
                        Text(
                            text = objectName ?: "",
                            color = Color.Black,
                            fontSize = 16.sp,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DetailsAppBar(modifier: Modifier, onBackPressed: () -> Unit) {
    ConstraintLayout(modifier) {
        val (back) = createRefs()
        RecipeGradient(modifier = Modifier.fillMaxSize())
        IconButton(
            onClick = onBackPressed,
            Modifier.constrainAs(back) {
                start.linkTo(parent.start, margin = 8.dp)
                top.linkTo(parent.top, margin = 8.dp)
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }


    }
}

@Composable
fun RecipeGradient(modifier: Modifier) {
    Spacer(
        modifier = modifier.verticalGradient()
    )
}

fun Modifier.verticalGradient(): Modifier = composed {
    val color = Color.Black.copy(alpha = 0.3f)
    val colors = remember { listOf(color.copy(alpha = 0f), color) }

    var height by remember { mutableStateOf(0f) }
    val brush = remember(color, height) {
        Brush.verticalGradient(
            colors = colors,
            startY = height * 1f,
            endY = height * 0f
        )
    }

    drawBehind {
        height = size.height
        drawRect(brush = brush)
    }
}

