package org.jilse.project.ui.screens.home.tabs.episodes

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.jilse.project.domain.models.EpisodeModel

data class EpisodesState(
    val episodes: Flow<PagingData<EpisodeModel>> = emptyFlow(),
    val playVideo: String = ""
)
