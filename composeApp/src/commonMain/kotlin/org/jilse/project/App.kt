package org.jilse.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jilse.project.ui.core.navigation.NavigationManager

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationManager()
    }
}