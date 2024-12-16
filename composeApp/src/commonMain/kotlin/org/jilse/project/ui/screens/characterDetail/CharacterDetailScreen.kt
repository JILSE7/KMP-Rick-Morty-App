package org.jilse.project.ui.screens.characterDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.ui.core.extension.aliveBorder
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

    Column(modifier = Modifier.fillMaxSize()){
        MainHeader(state.character)
        CharacterInfo(state.character)
    }

}

@Composable
fun CharacterInfo(character: CharacterModel) {
    ElevatedCard(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()){
        Column(modifier = Modifier.padding(16.dp)) {
            Text("About ${character.name}", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            InformationDetail("Origin", character.origin)
            Spacer(modifier = Modifier.height(4.dp))
            InformationDetail("Gender", character.gender)
        }
    }
}




@Composable
fun InformationDetail (title: String, detail: String) {
    Row {
        Text(title, color = Color.White, fontWeight = FontWeight.Bold)
        Text(detail, color = Color.Green)
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
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
                .background(Color.White).border(10.dp, Color.Blue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(character.name, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("Specie: ${character.species}", color = Color.Black)

        }

        Column(
            modifier = Modifier.fillMaxSize().border(1.dp, Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Box(contentAlignment = Alignment.TopCenter) {
                Box(
                    modifier = Modifier.size(205.dp).clip(CircleShape).background(Color.Black.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ){
                    AsyncImage(
                        model = character.picture,
                        contentDescription = null,
                        modifier = Modifier.size(190.dp).clip(CircleShape).aliveBorder(character.isAlive),
                        contentScale = ContentScale.Crop
                    )
                }

                val aliveCopy = if (character.isAlive) "Alive" else "Dead"
                val aliveColor = if (character.isAlive) Color.Green else Color.Red
                Text(
                    aliveCopy, color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clip(RoundedCornerShape(30)).background(aliveColor).padding(horizontal = 6.dp, vertical = 2.dp)
                )

                /*Spacer(Modifier.weight(, true))*/
            }
        }
    }
}
