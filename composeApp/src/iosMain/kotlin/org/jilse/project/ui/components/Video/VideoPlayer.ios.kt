package org.jilse.project.ui.components.Video

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.UIKit.UIView
import platform.UIKit.UIViewAutoresizingFlexibleHeight
import platform.UIKit.UIViewAutoresizingFlexibleWidth
import platform.WebKit.WKWebView


@Composable
actual fun VideoPlayer(modifier: Modifier, videoUrl: String) {

    val webView = remember { WKWebView() }

    UIKitView(
        modifier = modifier,
        factory = {
            val container = UIView().apply {
                autoresizingMask = UIViewAutoresizingFlexibleWidth or UIViewAutoresizingFlexibleHeight
            }

            webView.apply {
                autoresizingMask = UIViewAutoresizingFlexibleWidth or UIViewAutoresizingFlexibleHeight
                loadRequest(NSURLRequest(NSURL(string = videoUrl)))
            }

            container.addSubview(webView)
            container
        },
        update = { views ->
            views.subviews().firstOrNull { it is WKWebView}
        }
    )

}