package org.jilse.project.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.jilse.project.data.database.dao.UserPreferenceDao
import org.jilse.project.data.database.entities.CharacterOfTheDayEntity

const val DATABASE_NAME = "rm_app_database.db"

expect object RickMortyCTor: RoomDatabaseConstructor<RickMortyDatabase>

@Database(entities = [CharacterOfTheDayEntity::class], version = 1)
@ConstructedBy(RickMortyCTor::class)
abstract class RickMortyDatabase: RoomDatabase() {
    // abstract fun characterDao(): CharacterDao
    abstract fun getPreferencesDao(): UserPreferenceDao
}