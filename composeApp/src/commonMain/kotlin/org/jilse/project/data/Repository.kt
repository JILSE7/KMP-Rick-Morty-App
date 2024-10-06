package org.jilse.project.data

import org.jilse.project.data.remote.ApiService
import org.jilse.project.domain.IRepository
import org.jilse.project.domain.models.CharacterModel

class Repository(private val api: ApiService): IRepository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

}