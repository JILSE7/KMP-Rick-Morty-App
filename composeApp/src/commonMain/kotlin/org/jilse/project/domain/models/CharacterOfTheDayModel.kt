package org.jilse.project.domain.models

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jilse.project.data.database.entities.CharacterOfTheDayEntity

data class CharacterOfTheDayModel(
    val characterModel: CharacterModel,
    val date: String
) {
    fun toEntity(): CharacterOfTheDayEntity {
        return CharacterOfTheDayEntity(
            id = characterModel.id,
            name = characterModel.name,
            isAlive = characterModel.isAlive,
            picture = characterModel.picture,
            date = date,
            species = characterModel.species,
            gender = characterModel.gender,
            episodes = Json.encodeToString(characterModel.episodes),
            origin = characterModel.origin
        )
    }
}