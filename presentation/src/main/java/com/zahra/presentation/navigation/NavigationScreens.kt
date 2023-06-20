package com.zahra.presentation.navigation

sealed class NavigationScreens(val route: String) {
    object SplashScreen : NavigationScreens("splash_screen")
    object ListScreen : NavigationScreens("list_screen")
    object DetailsScreen : NavigationScreens("details_screen/{id}")
}