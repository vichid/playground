plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradle)
    implementation(libs.gradlePlugins.android)
}
