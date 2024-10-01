package org.jilse.project.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jilse.project.ui.screens.Home.HomeScreen

@Composable
fun NavigationManager() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Router.Home.route) {
        composable(route = Router.Home.route) {
            HomeScreen(navController)
        }
    }
}