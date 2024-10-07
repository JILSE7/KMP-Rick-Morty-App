package org.jilse.project.ui.screens.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.domain.useCases.GetRandomCharacter

class CharacterViewModel(val getRandomCharacter: GetRandomCharacter): ViewModel() {
    private val _state = MutableStateFlow<CharacterState>(CharacterState()) //  mutable
    val state: StateFlow<CharacterState> = _state // read only

    init {
        viewModelScope.launch {
            val character: CharacterModel = withContext(Dispatchers.IO){
                getRandomCharacter()
            }

            _state.update { state ->
                state.copy(characterOfTheDay = character)
            }

        }
    }


}