package org.jilse.project.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.json.Json
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.domain.models.CharacterOfTheDayModel

@Entity(tableName = "character_of_the_day")
data class CharacterOfTheDayEntity(
    @PrimaryKey val id: String,
    val name: String,
    val isAlive: Boolean,
    val picture: String,
    val date: String,
    val species: String,
    val gender: String,
    val origin: String,
    val episodes: String
) {
    fun toDomain(): CharacterOfTheDayModel {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                name,
                isAlive = isAlive,
                picture,
                species = species,
                gender,
                origin = origin,
                episodes = Json.decodeFromString<List<String>>(episodes)
            ),
            date = date
        )
    }
}