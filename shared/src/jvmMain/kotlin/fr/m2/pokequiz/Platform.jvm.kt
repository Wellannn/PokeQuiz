package fr.m2.pokequiz

private class JVMPlatform : Platform {
    override val name: String =
        "Desktop (${System.getProperty("os.name")}) Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()
