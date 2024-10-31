package org.jilse.project.domain.models

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

        )
    }
}