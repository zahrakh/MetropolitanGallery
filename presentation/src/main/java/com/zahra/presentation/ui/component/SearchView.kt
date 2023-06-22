package com.zahra.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.presentation.R

@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    onTextChange: (String) -> Unit,
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
    ) {
        TextField(
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_hint_text),
                    color = Color.Gray
                )
            },
            value = state.value,
            onValueChange = { value ->
                state.value = value
                onTextChange(value.text)
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .height(54.dp),
            textStyle = TextStyle(color = Color.DarkGray, fontSize = 14.sp),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp)
                )
            },
            trailingIcon = {
                if (state.value != TextFieldValue("")) {
                    IconButton(onClick = {
                        state.value = TextFieldValue("")
                        onTextChange("")
                    }) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(8.dp)
                                .size(24.dp)
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.DarkGray,
                cursorColor = Color.Gray,
                leadingIconColor = Color.DarkGray,
                trailingIconColor = Color.DarkGray,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}
