package org.jilse.project.ui.core.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.jilse.project.ui.screens.home.tabs.characters.CharactersTabScreen
import org.jilse.project.ui.screens.home.tabs.episodes.EpisodesTabScreen


@Composable
fun BottomNavigationManager(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Router.Episodes.route) {
        composable(route = Router.Episodes.route){
            EpisodesTabScreen()
        }

        composable(route = Router.Characters.route){
            CharactersTabScreen()
        }
    }
}