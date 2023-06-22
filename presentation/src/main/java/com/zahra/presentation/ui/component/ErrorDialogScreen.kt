package com.zahra.presentation.ui.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.zahra.presentation.R


@Composable
fun ErrorDialogScreen(
    onDismissDialog: () -> Unit,
    onBackClick: () -> Unit,
    onRetryClick: () -> Unit,
) {

    Dialog(onDismissRequest = { onDismissDialog() }) {
        Surface(
            shape = RoundedCornerShape(16.dp), color = Color.White
        ) {
            Box {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.error_message),
                            style = TextStyle(
                                fontSize = 16.sp, fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.padding(8.dp)) {
                        Row {
                            Button(
                                onClick = {
                                    onRetryClick()
                                    onDismissDialog()
                                },
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier
                                    .width(80.dp)
                                    .wrapContentHeight()
                                    .padding(4.dp)

                            ) {
                                Text(
                                    text = stringResource(
                                        id = R.string.retry
                                    ),
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White
                                    )
                                )
                            }

                            Button(
                                onClick = {
                                    onBackClick()
                                    onDismissDialog()
                                },
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier
                                    .width(80.dp)
                                    .wrapContentHeight()
                                    .padding(4.dp)

                            ) {
                                Text(
                                    text = stringResource(
                                        id = R.string.back
                                    ), style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White
                                    )
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}