package com.zahra.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.presentation.ui.animation.FadeInScreen
import com.zahra.presentation.ui.theme.LightPrimary

@Composable
fun ErrorView(
    errorMessage: String,
    visible: Boolean,
) {
    FadeInScreen(visible = visible) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    text = errorMessage,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier
                        .background(
                            shape = RoundedCornerShape(8.dp),
                            color = LightPrimary
                        )
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.height(18.dp))
            }
        }
    }
}
