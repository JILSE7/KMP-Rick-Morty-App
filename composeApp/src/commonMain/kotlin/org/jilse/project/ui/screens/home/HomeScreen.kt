package org.jilse.project.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.jilse.project.ui.components.BottomNavigation.BottomBarItem
import org.jilse.project.ui.components.BottomNavigation.BottomNavigation
import org.jilse.project.ui.core.navigation.BottomNavigationManager

@Composable
fun HomeScreen(navController: NavController) {
    val bottomController = rememberNavController()

    val items = listOf<BottomBarItem>(
        BottomBarItem.Episodes(),
        BottomBarItem.Characters(),
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(bottomController, items)
        }
    ){ padding ->
        Box(modifier = Modifier.padding(padding)) {
            BottomNavigationManager(bottomController)
        }
    }
}