package org.jilse.project.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jilse.project.domain.models.CharacterModel

@Serializable
data class CharacterByIdResponse (
    val id: Int,
    val name: String,
    val status: String,
    @SerialName("image")
    val picture: String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id.toString(),
            name,
            isAlive = status.lowercase() == "alive",
            picture
        )
    }
}