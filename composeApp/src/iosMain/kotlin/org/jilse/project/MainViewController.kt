package org.jilse.project

import androidx.compose.ui.window.ComposeUIViewController
import org.jilse.project.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }