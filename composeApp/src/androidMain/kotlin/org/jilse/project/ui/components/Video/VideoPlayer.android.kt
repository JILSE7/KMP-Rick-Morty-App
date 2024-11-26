package org.jilse.project.ui.components.Video

import android.widget.VideoView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun VideoPlayer(modifier: Modifier, videoUrl: String) {
    AndroidView(modifier = modifier, factory = {
        val videoView = VideoView(it)
        videoView.apply {
            setVideoPath(videoUrl)
            setMediaController(android.widget.MediaController(context).apply {
                setAnchorView(videoView)
            })
            start()
        }
    })
}