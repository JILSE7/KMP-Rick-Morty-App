package org.jilse.project.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.domain.models.CharacterOfTheDayModel
import org.jilse.project.domain.models.EpisodeModel

interface IRepository {
    suspend fun getSingleCharacter(id: String): CharacterModel

    // getCharacters no es suspend porque paging3 gestiona el flujo de datos y regresa un flow
    fun getCharacters(): Flow<PagingData<CharacterModel>>

    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>

    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayModel?

    suspend fun saveCharacterOfTheDay(character: CharacterOfTheDayModel)



}