plugins {
    id("io.github.vichid.library.compose")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.featureList.api)
    implementation(projects.androidApp.coreNavigation.api)

    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.uiToolingPreview)
    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
}
