plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.gradlePlugins.versionUpdate)
    implementation(libs.gradlePlugins.moduleGraphAssertion)
}
