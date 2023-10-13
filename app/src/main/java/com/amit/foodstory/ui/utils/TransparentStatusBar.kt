package com.amit.foodstory.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TransparentStatusBar(isDarkMode: Boolean) {
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(isDarkMode) {
        systemUiController.setStatusBarColor(Color.Transparent, !isDarkMode)
    }
}