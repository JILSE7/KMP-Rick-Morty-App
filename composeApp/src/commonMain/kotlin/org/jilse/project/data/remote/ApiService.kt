package org.jilse.project.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.jilse.project.data.remote.response.CharacterResponse

class ApiService(private val httpClient: HttpClient) {
    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return httpClient.get("/api/character/$id").body<CharacterResponse>()
    }
}