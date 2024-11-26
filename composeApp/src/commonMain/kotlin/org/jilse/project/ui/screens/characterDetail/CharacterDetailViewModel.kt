package org.jilse.project.ui.screens.characterDetail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.jilse.project.domain.models.CharacterModel

class CharacterDetailViewModel(characterModel: CharacterModel): ViewModel() {


    private val _state = MutableStateFlow<CharacterDetailState>(CharacterDetailState(characterModel))
    val state: StateFlow<CharacterDetailState> = _state
}