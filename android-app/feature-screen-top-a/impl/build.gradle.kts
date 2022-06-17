plugins {
    id("io.github.vichid.library.compose")
    id("com.squareup.anvil")
}
dependencies {
    api(projects.androidApp.featureScreenTopA.api)
    api(projects.androidApp.featureScreenChildA.api)

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    debugImplementation(libs.androidx.compose.uiTooling)
    implementation(libs.androidx.compose.uiToolingPreview)

    implementation(projects.androidApp.coreNavigation.api)
    implementation(libs.androidx.compose.navigation)

    implementation(projects.androidApp.coreLogger.api)

    implementation(projects.androidApp.coreDi.api)
    implementation(projects.androidApp.coreDiUtils.api)
}
