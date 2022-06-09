plugins {
    id("io.github.vichid.library.compose")
    id("com.squareup.anvil")
}

dependencies {
    anvil(projects.androidApp.anvilCodeGen)

    implementation(projects.androidApp.coreDi.api)
    implementation(projects.androidApp.coreDiUtils.api)
    api(projects.androidApp.featureList.api)
    implementation(projects.androidApp.coreNavigation.api)

    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.uiToolingPreview)
}
