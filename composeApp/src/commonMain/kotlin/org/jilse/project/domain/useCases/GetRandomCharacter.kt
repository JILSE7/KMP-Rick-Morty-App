package org.jilse.project.domain.useCases



import org.jilse.project.data.RepositoryImp
import org.jilse.project.domain.models.CharacterModel

class GetRandomCharacter(private val repository: RepositoryImp) {
    suspend operator fun invoke(): CharacterModel {
        val randomId: Int = (1 .. 826).random()
        return repository.getSingleCharacter(randomId.toString())
    }
}