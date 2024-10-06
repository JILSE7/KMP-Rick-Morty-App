package org.jilse.project.ui.screens.home.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun EpisodesTabScreen() {
    val name = helloName()
    Text("Episode Screen $name")
}

expect fun helloName(): String

