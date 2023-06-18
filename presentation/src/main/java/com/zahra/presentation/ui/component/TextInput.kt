package com.zahra.presentation.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.presentation.R
import com.zahra.presentation.ui.animation.FadeInScreen
import com.zahra.presentation.ui.shape.TextFieldBackground

@Preview
@Composable
fun TextFieldWithIcons(hint: String? = null, visible: Boolean = true) = FadeInScreen(visible) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 42.dp,
                    end = 16.dp,
                    bottom = 8.dp,
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = hint ?: "",
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = FontFamily.SansSerif
            )
        }
        Row {
            OutlinedTextField(
                value = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .border(
                        width = 1.dp,
                        brush = TextFieldBackground,
                        shape = RoundedCornerShape(12.dp)
                    ),
                textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
                leadingIcon = {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = stringResource(id = R.string.input_view_icon)
                    )
                },
                onValueChange = {},
                shape = RoundedCornerShape(12.dp),
            )
        }
    }


}