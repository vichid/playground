plugins {
    id("io.github.vichid.library.compose")
}
dependencies {
    api(projects.androidApp.featureScreenTopB.api)
    api(projects.androidApp.featureScreenChildB.api)

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    debugImplementation(libs.androidx.compose.uiTooling)
    implementation(libs.androidx.compose.uiToolingPreview)

    implementation(projects.androidApp.coreNavigation.api)
    implementation(libs.androidx.compose.navigation)
}
