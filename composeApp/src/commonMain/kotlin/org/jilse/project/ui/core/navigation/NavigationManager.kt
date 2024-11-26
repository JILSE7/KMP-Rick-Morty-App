package org.jilse.project.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.json.Json
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.ui.screens.characterDetail.CharacterDetailScreen
import org.jilse.project.ui.screens.home.HomeScreen

@Composable
fun NavigationManager() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Router.Home.route) {
        composable(route = Router.Home.route) {
            HomeScreen(navController)
        }

        composable<CharacterDetail>{ navBackStackEntry ->
            val characterDetailEncoding: CharacterDetail =
                navBackStackEntry.toRoute<CharacterDetail>()
            val characterModel: CharacterModel =
                Json.decodeFromString<CharacterModel>(characterDetailEncoding.character)
            CharacterDetailScreen(characterModel)
        }
    }
}