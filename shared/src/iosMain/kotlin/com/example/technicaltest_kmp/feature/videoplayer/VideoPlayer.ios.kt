package com.example.technicaltest_kmp.feature.videoplayer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.viewinterop.UIKitInteropProperties
import androidx.compose.ui.viewinterop.UIKitView
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.*
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.Foundation.NSURL
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun VideoPlayer(videoUrl: String, modifier: Modifier) {

    val nsUrl = NSURL.URLWithString(videoUrl)
    val playerItem = nsUrl?.let { AVPlayerItem(it) }
    val avPlayer = AVPlayer(playerItem)

    DisposableEffect("avPlayerViewController") {
        onDispose {
            avPlayer.pause()
        }
    }


    val playbackLayer = remember { AVPlayerLayer() }
    val avPlayerViewController = remember { AVPlayerViewController() }
    avPlayerViewController.player = remember { avPlayer }
    avPlayerViewController.showsPlaybackControls = true
    playbackLayer.player = avPlayer


    UIKitView(
        factory = {
            val playerContainer = UIView()
            playerContainer.addSubview(avPlayerViewController.view)
            playerContainer
        },
        onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            view.layer.setFrame(rect)
            playbackLayer.setFrame(rect)
            avPlayerViewController.view.layer.frame = rect
            CATransaction.commit()
        },
        update = {
            avPlayer.play()
            avPlayerViewController.player?.play()
        }, onRelease = {
            avPlayerViewController.player
        },
        modifier = modifier
    )

    /*{ view: UIView, rect: CValue<CGRect> ->
        CATransaction.begin()
        CATransaction.setValue(true, kCATransactionDisableActions)
        view.layer.setFrame(rect)
        playbackLayer.setFrame(rect)
        avPlayerViewController.view.layer.frame = rect
        CATransaction.commit()
    }

    UIKitView(
        factory = {
            val playerContainer = UIView()
            playerContainer.addSubview(avPlayerViewController.view)
            playerContainer
        },
        modifier = modifier,
        update = {
            avPlayerViewController.player?.play()
        },
        onRelease = {
            avPlayer.removeAllItems()
            avPlayerViewController.player?.pause()
        },
        properties = UIKitInteropProperties(isInteractive = true, isNativeAccessibilityEnabled = true),
    )*/
}