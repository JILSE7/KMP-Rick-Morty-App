package org.jilse.project.di

import org.jilse.project.ui.screens.characterDetail.CharacterDetailViewModel
import org.jilse.project.ui.screens.home.tabs.characters.CharacterViewModel
import org.jilse.project.ui.screens.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val UIModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharacterViewModel)
    viewModelOf(::CharacterDetailViewModel)
}
