package org.jilse.project.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val isAlive: Boolean,
    val picture: String,
    val date: String
)