package org.jilse.project.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jilse.project.domain.models.CharacterModel

@Serializable
data class CharacterResponse (
    val id: String,
    val status: String,
    @SerialName("image")
    val picture: String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id,
            isAlive = status.lowercase() == "alive",
            picture
        )
    }
}