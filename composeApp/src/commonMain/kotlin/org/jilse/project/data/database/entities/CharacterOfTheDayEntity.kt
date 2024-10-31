package org.jilse.project.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.domain.models.CharacterOfTheDayModel

@Entity(tableName = "character_of_the_day")
data class CharacterOfTheDayEntity(
    @PrimaryKey val id: String,
    val name: String,
    val isAlive: Boolean,
    val picture: String,
    val date: String
) {
    fun toDomain(): CharacterOfTheDayModel {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                name,
                isAlive = isAlive,
                picture,
            ),
            date = date
        )
    }
}