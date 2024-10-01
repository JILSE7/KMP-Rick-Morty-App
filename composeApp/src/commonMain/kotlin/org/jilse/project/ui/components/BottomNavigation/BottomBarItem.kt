package org.jilse.project.ui.components.BottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import org.jilse.project.ui.core.navigation.Router

sealed class BottomBarItem {
    abstract val route: String
    abstract val title: String
    abstract val icon: @Composable () -> Unit


    data class Episodes (
        override val route: String = Router.Episodes.route,
        override val title: String = Router.Episodes.title,
        override val icon: @Composable () -> Unit = { Icon(imageVector = Icons.Default.Home, contentDescription = "homeIcon") }
    ): BottomBarItem()

    data class Characters(
        override val route: String = Router.Characters.route,
        override val title: String = Router.Characters.title,
        override val icon: @Composable () -> Unit = { Icon(imageVector = Icons.Default.Person, contentDescription = "homeIcon") }
    ): BottomBarItem()
}