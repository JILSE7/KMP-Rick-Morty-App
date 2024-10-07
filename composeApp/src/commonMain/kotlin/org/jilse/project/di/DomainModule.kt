package org.jilse.project.di

import org.jilse.project.domain.useCases.GetRandomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val DomainModule = module {
    factoryOf(::GetRandomCharacter)
}