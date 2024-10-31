package org.jilse.project.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.domain.models.CharacterOfTheDayModel

interface IRepository {
    suspend fun getSingleCharacter(id: String): CharacterModel

    // getCharacters no es suspend porque paging3 gestiona el flujo de datos y regresa un flow
    fun getCharacters(): Flow<PagingData<CharacterModel>>

    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayModel?

    suspend fun saveCharacterOfTheDay(character: CharacterOfTheDayModel)

}