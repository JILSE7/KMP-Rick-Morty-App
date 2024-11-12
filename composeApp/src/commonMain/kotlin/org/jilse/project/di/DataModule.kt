package org.jilse.project.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.jilse.project.data.RepositoryImp
import org.jilse.project.data.remote.ApiService
import org.jilse.project.data.remote.paging.CharacterPagingSource
import org.jilse.project.data.remote.paging.EpisodesPagingSource
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

const val URL_BASE = "rickandmortyapi.com"

val DataModule = module {
    single {
        HttpClient{
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any )
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = URL_BASE
                    /*parameters.append("key", "value")*/
                }
            }
        }
    }

    factoryOf(::ApiService)
    factoryOf(::RepositoryImp)
    factoryOf(::CharacterPagingSource)
    factoryOf(::EpisodesPagingSource)
}