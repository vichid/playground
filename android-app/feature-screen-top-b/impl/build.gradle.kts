plugins {
    id("io.github.vichid.library.compose")
    id("com.squareup.anvil")
}
dependencies {
    api(projects.androidApp.featureScreenTopB.api)

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    debugImplementation(libs.androidx.compose.uiToolingPreview)

    implementation(projects.androidApp.coreDi.api)
    implementation(projects.androidApp.coreNavigation.api)
    implementation(libs.androidx.compose.navigation)
}
