//package com.zahra.presentation.ui.component
//
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.Button
//import androidx.compose.material.Icon
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.material.TextFieldDefaults
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.window.Dialog
//import com.zahra.presentation.R
//import com.zahra.presentation.ui.theme.OrangeDarkColor
//
//
//@Composable
//fun LocationDialogScreen(
//    value: String,
//    setShowDialog: (Boolean) -> Unit,
//    setValue: (String) -> Unit
//) {
//    val txtFieldError = remember { mutableStateOf("") }
//    val txtField = remember { mutableStateOf(value) }
//
//    Dialog(onDismissRequest = { setShowDialog(false) }) {
//        Surface(
//            shape = RoundedCornerShape(16.dp), color = Color.White
//        ) {
//            Box(
//                contentAlignment = Alignment.Center
//            ) {
//                Column(modifier = Modifier.padding(20.dp)) {
//
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = stringResource(id = R.string.location_dialog_title),
//                            style = TextStyle(
//                                fontSize = 16.sp, fontWeight = FontWeight.Bold
//                            )
//                        )
//                        Icon(imageVector = Icons.Filled.Close,
//                            contentDescription = "",
//                            tint = Color.DarkGray,
//                            modifier = Modifier
//                                .width(30.dp)
//                                .height(30.dp)
//                                .clickable { setShowDialog(false) })
//                    }
//
//                    Spacer(modifier = Modifier.height(20.dp))
//
//                    TextField(modifier = Modifier
//                        .fillMaxWidth()
//                        .border(
//                            BorderStroke(
//                                width = 2.dp,
//                                color = if (txtFieldError.value.isEmpty()) Color.Gray else Color.Red
//                            ), shape = RoundedCornerShape(50)
//                        ),
//                        colors = TextFieldDefaults.textFieldColors(
//                            backgroundColor = Color.Transparent,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        leadingIcon = {
//                            Icon(
//                                imageVector = Icons.Filled.LocationOn,
//                                contentDescription = "",
//                                tint = OrangeDarkColor,
//                                modifier = Modifier
//                                    .width(20.dp)
//                                    .height(20.dp)
//                            )
//                        },
//                        placeholder = { Text(text = stringResource(id = R.string.post_code)) },
//                        value = txtField.value,
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//                        onValueChange = {
//                            txtField.value = it
//                        })
//
//                    Spacer(modifier = Modifier.height(20.dp))
//
//                    Box(modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp)) {
//                        Row {
//                            Button(
//                                onClick = {
//                                    if (txtField.value.isEmpty()) {
//                                        return@Button
//                                    }
//                                    setValue(txtField.value)
//                                    setShowDialog(false)
//                                },
//                                shape = RoundedCornerShape(30.dp),
//                                modifier = Modifier
//                                    .wrapContentSize()
//                                    .padding(4.dp)
//
//                            ) {
//                                Text(
//                                    text = stringResource(id = R.string.confirm), style = TextStyle(
//                                        fontSize = 14.sp,
//                                    )
//                                )
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//    }
//}