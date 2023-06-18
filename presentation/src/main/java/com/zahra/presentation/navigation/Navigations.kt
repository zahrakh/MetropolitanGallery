package com.zahra.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zahra.presentation.explorelist.screen.LazyListScreen
import com.zahra.presentation.splash.SplashScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.SplashScreen.route,
    ) {
        composable(
            route = NavigationScreens.SplashScreen.route,
        ) {
            SplashScreen(
                navigateToFirstPage = {
                    navController.navigate(NavigationScreens.ListScreen.route) {
                        popUpTo(NavigationScreens.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = NavigationScreens.ListScreen.route) {
            LazyListScreen()
        }


    }
}