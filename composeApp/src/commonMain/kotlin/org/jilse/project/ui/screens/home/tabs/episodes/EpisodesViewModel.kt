package org.jilse.project.ui.screens.home.tabs.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.jilse.project.data.RepositoryImp

class EpisodesViewModel(private val repository: RepositoryImp): ViewModel() {

    private val _state = MutableStateFlow(EpisodesState())
    val state: StateFlow<EpisodesState> = _state

    init {
        _state.update { state -> state.copy(episodes = repository.getAllEpisodes().cachedIn(viewModelScope)) }
    }

    fun onPlaySelected(videoUrl: String) {
        _state.update { state -> state.copy(playVideo = videoUrl) }
    }

    fun onFinishPlay() {
        _state.update { state -> state.copy(playVideo = "") }
    }

}