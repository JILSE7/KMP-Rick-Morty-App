package org.jilse.project.di

import org.jilse.project.data.database.RickMortyDatabase
import org.jilse.project.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single <RickMortyDatabase>{ getDatabase() }
    }
}