package org.jilse.project.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel (
    val id: String,
    val name: String,
    val isAlive: Boolean,
    val picture: String,
    val species: String,
    val gender: String,
    val origin: String,
    val episodes: List<String>
)