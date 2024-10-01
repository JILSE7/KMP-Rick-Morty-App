package org.jilse.project.ui.core.navigation

sealed class Router(val route: String, val title: String) {
    data object Home : Router("home", "Home")

    data object Episodes: Router("episodes", "Episodes")
    data object Characters: Router("characters", "Characters")
}