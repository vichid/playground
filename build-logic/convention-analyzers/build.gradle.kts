plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {

    implementation(libs.gradlePlugins.ktlint)
}
