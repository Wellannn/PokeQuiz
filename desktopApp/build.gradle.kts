plugins {
    id("org.jetbrains.kotlin.jvm")
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose)
    application
}

dependencies {
    implementation(project(":shared"))
    implementation(compose.desktop.currentOs)
}

application {
    mainClass.set("fr.m2.pokequiz.MainKt")
}
