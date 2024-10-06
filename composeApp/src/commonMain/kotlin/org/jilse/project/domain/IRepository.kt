package org.jilse.project.domain

import org.jilse.project.domain.models.CharacterModel

interface IRepository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}