package com.zahra.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.presentation.R
import com.zahra.presentation.ui.animation.FadeInScreen
import com.zahra.presentation.ui.theme.LightGreen

@Composable
fun ErrorView(
    errorMessage: String,
    ocClick: () -> Unit,
    visible: Boolean,
) {
    FadeInScreen(visible = visible) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Info,
                    modifier = Modifier
                        .width(8.dp)
                        .height(8.dp)
                        .padding(4.dp),
                    contentDescription = stringResource(id = R.string.icon_image),
                    tint = LightGreen
                )
                Text(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    text = errorMessage,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                )
                Spacer(modifier = Modifier.height(18.dp))
            }
            Row {
                Button(
                    text = stringResource(id = R.string.retry),
                    onClick = ocClick,
                )
            }
        }
    }
}
