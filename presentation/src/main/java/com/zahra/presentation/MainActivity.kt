package com.zahra.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zahra.presentation.navigation.Navigation
import com.zahra.presentation.ui.theme.MetropolitanGalleryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetropolitanGalleryTheme {
                Navigation()
            }
        }
    }
}

