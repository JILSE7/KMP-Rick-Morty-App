package org.jilse.project.ui.screens.characterDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jilse.project.domain.models.CharacterModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parameterSetOf
import rickmortykmp.composeapp.generated.resources.Res
import rickmortykmp.composeapp.generated.resources.space

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharacterDetailScreen(character: CharacterModel) {

    val characterDetailViewModel = koinViewModel<CharacterDetailViewModel>(parameters = { parameterSetOf(character)})

    val state by characterDetailViewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize().background(Color.White)){
        MainHeader(state.character)
    }

}


@Composable
fun MainHeader(character: CharacterModel) {
    Box(modifier = Modifier.fillMaxWidth().height(300.dp)){
        Image(
            painter = painterResource(Res.drawable.space),
            contentDescription = "Background Header",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        CharacterHeader(character)
    }

}

@Composable
fun CharacterHeader(character: CharacterModel) {
    TODO("Not yet implemented")
}
