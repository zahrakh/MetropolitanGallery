package com.zahra.presentation.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = DarkGray,
            contentColor = White
        ),
        shape = CircleShape,
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = White
        )
    }
}