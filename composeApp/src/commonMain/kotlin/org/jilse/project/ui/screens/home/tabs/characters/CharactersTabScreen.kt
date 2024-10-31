package org.jilse.project.ui.screens.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.ui.core.extension.vertical
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickmortykmp.composeapp.generated.resources.Res
import rickmortykmp.composeapp.generated.resources.rickface

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharactersTabScreen() {
    val characterViewModel = koinViewModel<CharacterViewModel>()
    val state by characterViewModel.state.collectAsState()
    val characters = state.characters.collectAsLazyPagingItems()


    CharactersGridList(characters, state.characterOfTheDay)
}


@Composable
fun CharacterOfTheDay(character: CharacterModel? = null) {
    Card(modifier = Modifier.fillMaxWidth().height(400.dp).padding(top = 24.dp), shape = RoundedCornerShape(12)) {

        if (character == null) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
            return@Card
        }

        Box(contentAlignment = Alignment.BottomStart) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Color.Green.copy(alpha = 0.5f))
            )

            AsyncImage(
                model = character.picture,
                contentDescription = "CharacterOfTheDay",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier.fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            0f to Color.Black.copy(alpha = 0.9f),
                            0.5f to Color.White.copy(alpha = 0.2f),
                            1f to Color.White.copy(alpha = 0f)
                        )
                    )
            )
            Text(
                text = character.name,
                fontSize = 40.sp,
                maxLines = 1,
                minLines = 1,
                textAlign = TextAlign.Center,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp).fillMaxHeight().vertical()
                    .rotate(-90f),
            )
        }
    }
}


@Composable
fun CharactersGridList(characters: LazyPagingItems<CharacterModel>, characterOfTheDay: CharacterModel? = null ) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = rememberLazyGridState()
    ) {

        item(span = { GridItemSpan(2) }) {
            Column{
                Text("Character", color = Color.Black, fontSize = 24.sp)
                CharacterOfTheDay(characterOfTheDay)
            }

        }
        when {
            characters.loadState.refresh is LoadState.Loading && characters.itemCount == 0 -> {
                // Initial load
                item(span = { GridItemSpan(2) }) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(Modifier.size(64.dp), color = Color.Red)
                    }
                }
            }

            characters.loadState.refresh is LoadState.NotLoading && characters.itemCount == 0 -> {
                // Empty list
                item(span = { GridItemSpan(2) }) {
                    Text("No hay personajes")
                }
            }

            else -> {

                items(characters.itemCount) { index ->
                    characters[index]?.let { character ->
                        CharacterGridItem(character)
                    }
                }

                if (true) {
                    item(span = { GridItemSpan(2) }) {
                        Box(
                            modifier = Modifier.fillMaxHeight().height(100.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(Modifier.size(64.dp), color = Color.Red)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun CharacterGridItem(character: CharacterModel) {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(24))
            .border(
                2.dp,
                Color.Green,
                shape = RoundedCornerShape(0, 24, 0, 24)
            )
            .fillMaxWidth()
            .height(150.dp)
            .clickable { },
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = character.picture,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            placeholder = painterResource(Res.drawable.rickface)
        )

        Box(
            modifier = Modifier.fillMaxWidth().height(60.dp).background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black.copy(0f),
                        Color.Black.copy(0.6f),
                        Color.Black.copy(1f),
                    )
                )
            ), contentAlignment = Alignment.Center
        ) {
            Text(character.name, color = Color.White, fontSize = 18.sp)
        }
    }
}
