package org.jilse.project.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.jilse.project.data.database.entities.CharacterOfTheDayEntity

@Dao
interface UserPreferenceDao {
    @Query("SELECT * FROM character_of_the_day")
    suspend fun getCharacterOfTheDay(): CharacterOfTheDayEntity?

    @Insert(entity = CharacterOfTheDayEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacterOfTheDay(character: CharacterOfTheDayEntity)


}