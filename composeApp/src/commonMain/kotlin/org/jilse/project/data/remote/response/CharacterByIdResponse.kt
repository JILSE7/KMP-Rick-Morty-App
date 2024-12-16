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
    val picture: String,
    val species: String,
    val gender: String,
    val origin: OriginResponse,
    @SerialName("episode")
    val episodes: List<String>
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id.toString(),
            name,
            isAlive = status.lowercase() == "alive",
            picture,
            species,
            gender,
            origin =  origin.name,
            episodes = episodes.map { it.split("/").last() }
        )
    }
}

@Serializable
data class OriginResponse(
    val name: String,
)