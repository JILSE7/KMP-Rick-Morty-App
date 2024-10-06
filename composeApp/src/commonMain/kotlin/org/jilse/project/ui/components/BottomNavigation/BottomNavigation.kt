package org.jilse.project.ui.components.BottomNavigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(navController: NavHostController, items: List<BottomBarItem>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = item.icon,
                label = { Text(item.title) },
                selected = currentDestination?.hierarchy?.any{it.route == item.route} == true,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            // limpiar la pila
                            popUpTo(route) { saveState = true }
                        }
                        // no crea la misma pantalla si se pulsa muchas veces el mismo tab si ya existe
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = true

            )
        }
    }
}