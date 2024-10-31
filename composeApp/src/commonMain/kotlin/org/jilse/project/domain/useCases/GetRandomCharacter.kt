package org.jilse.project.domain.useCases



import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jilse.project.data.RepositoryImp
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.domain.models.CharacterOfTheDayModel

class GetRandomCharacter(private val repository: RepositoryImp) {
    suspend operator fun invoke(): CharacterModel {
        /*val characterDb = repository.saveDB()*/
        /*if (getCurrentDayOfTheYear() == characterDatabase.date) {

        }*/

        val currentDate = getCurrentDayOfTheYear()
        val characterEntity = repository.getCharacterOfTheDayDB()

        return if (characterEntity != null && characterEntity.date == currentDate) {
            characterEntity.characterModel
        }else {
            val result = getRandomCharacter()
            repository.saveCharacterOfTheDay(CharacterOfTheDayModel(result, currentDate))
            return result
        }

    }

    private suspend fun getRandomCharacter(): CharacterModel{
        val randomId: Int = (1 .. 826).random()
        return repository.getSingleCharacter(randomId.toString())
    }

    private fun getCurrentDayOfTheYear(): String {
        val calendar: Instant = Clock.System.now()
        val localtime: LocalDateTime = calendar.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localtime.dayOfYear}${localtime.year}"
    }
}