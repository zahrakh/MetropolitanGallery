package com.zahra.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zahra.presentation.objectdetails.ObjectDetailsFragment
import com.zahra.presentation.objectlist.ObjectListFragment
import com.zahra.presentation.splash.SplashScreen
import kotlinx.coroutines.FlowPreview


@OptIn(FlowPreview::class)
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
            ObjectListFragment(
                navigateToDetailsPage = { id ->
                    navController.navigate("details_screen/$id")
                }
            )
        }

        composable(
            route = NavigationScreens.DetailsScreen.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            }),
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val id = arguments.getInt("id")
            ObjectDetailsFragment(objectId = id) {
                navController.popBackStack()
            }
        }


    }
}