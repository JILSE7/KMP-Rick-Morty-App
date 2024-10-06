package org.jilse.project.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration


expect fun platformModule(): Module
fun initKoin(config:KoinAppDeclaration? = null) {
    startKoin{
        config?.invoke(this)
        modules(
            DomainModule,
            UIModule,
            DataModule,
            platformModule()
        )
    }
}