package org.jilse.project.ui.core.navigation

import kotlinx.serialization.Serializable

sealed class Router(val route: String, val title: String) {
    data object Home : Router("home", "Home")
    data object Episodes: Router("episodes", "Episodes")
    data object Characters: Router("characters", "Characters")
}

@Serializable
data class CharacterDetail(val character: String)