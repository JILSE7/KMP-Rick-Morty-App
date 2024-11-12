package org.jilse.project.ui.screens.home.tabs.episodes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jilse.project.domain.models.EpisodeModel
import org.jilse.project.domain.models.SeasonEpisode
import org.jilse.project.ui.components.Loaders.PagingLoader
import org.jilse.project.ui.components.Wrappers.PagingType
import org.jilse.project.ui.components.Wrappers.PagingWrapper
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickmortykmp.composeapp.generated.resources.Res
import rickmortykmp.composeapp.generated.resources.season1
import rickmortykmp.composeapp.generated.resources.season2
import rickmortykmp.composeapp.generated.resources.season3
import rickmortykmp.composeapp.generated.resources.season4
import rickmortykmp.composeapp.generated.resources.season5
import rickmortykmp.composeapp.generated.resources.season6
import rickmortykmp.composeapp.generated.resources.season7

@OptIn(KoinExperimentalAPI::class)
@Composable
fun EpisodesTabScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()

    val state by episodesViewModel.state.collectAsState()

    val episodes = state.episodes.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
        PagingWrapper(
            pagingType = PagingType.ROW,
            pagingItems = episodes,
            initialView = {
                PagingLoader()
            },
            emptyView = {},
            itemView = {
                EpisodeItemList(episode = it)
            }
        )
    }

}

@Composable
fun EpisodeItemList(episode: EpisodeModel) {
    Column(modifier = Modifier.width(120.dp).padding(horizontal = 8.dp)) {
        Image(
            modifier = Modifier.height(200.dp).fillMaxWidth(),
            contentDescription = episode.name,
            contentScale = ContentScale.Inside,
            painter = painterResource(getSeasonImage(episode.season))
        )
    }
}

fun getSeasonImage(season: SeasonEpisode): DrawableResource {
    return when (season) {
        SeasonEpisode.SEASON_1 -> Res.drawable.season1
        SeasonEpisode.SEASON_2 -> Res.drawable.season2
        SeasonEpisode.SEASON_3 -> Res.drawable.season3
        SeasonEpisode.SEASON_4 -> Res.drawable.season4
        SeasonEpisode.SEASON_5 -> Res.drawable.season5
        SeasonEpisode.SEASON_6 -> Res.drawable.season6
        SeasonEpisode.SEASON_7 -> Res.drawable.season7
        SeasonEpisode.UNKNOWN -> Res.drawable.season1
    }
}

