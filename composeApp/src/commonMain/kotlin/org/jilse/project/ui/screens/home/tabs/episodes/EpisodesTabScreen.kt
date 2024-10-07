package org.jilse.project.ui.screens.home.tabs.episodes

import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun EpisodesTabScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()

}

