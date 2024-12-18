package org.jilse.project.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.jilse.project.data.remote.response.CharacterByIdResponse
import org.jilse.project.data.remote.response.CharactersResponse
import org.jilse.project.data.remote.response.EpisodesResponse

class ApiService(private val httpClient: HttpClient) {
    suspend fun getSingleCharacter(id: String): CharacterByIdResponse {
        return httpClient.get("/api/character/$id").body<CharacterByIdResponse>()
    }

    suspend fun getCharacters(page: Int): CharactersResponse {
        return httpClient.get("/api/character/") {
            parameter("page", page)
        }.body<CharactersResponse>()
    }

    suspend fun getAllEpisodes(page: Int): EpisodesResponse {
        return httpClient.get("/api/episode/") {
            parameter("page", page)
        }.body<EpisodesResponse>()
    }
}