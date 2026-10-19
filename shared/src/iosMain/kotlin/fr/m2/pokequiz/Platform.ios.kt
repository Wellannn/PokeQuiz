package fr.m2.pokequiz

import platform.UIKit.UIDevice

private class IOSPlatform : Platform {
    override val name: String = "iOS ${UIDevice.currentDevice.systemVersion}"
}

actual fun getPlatform(): Platform = IOSPlatform()
