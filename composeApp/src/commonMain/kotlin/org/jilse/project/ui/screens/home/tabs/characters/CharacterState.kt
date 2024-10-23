package org.jilse.project.ui.screens.home.tabs.characters

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.jilse.project.domain.models.CharacterModel

data class CharacterState(
    val characterOfTheDay: CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)