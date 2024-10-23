package org.jilse.project.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    val info: InfoResponse,
    val results: List<CharacterByIdResponse>
)
@Serializable
data class InfoResponse(
    val pages: Int,
    val next: String?,
    val prev: String?,
)