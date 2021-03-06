plugins {
    id("io.github.vichid.library.compose")
    id("com.squareup.anvil")
}

dependencies {
    anvil(projects.androidApp.anvilCodeGen)

    implementation(projects.androidApp.coreDi.api)
    implementation(projects.androidApp.coreDiUtils.api)
    api(projects.androidApp.featureAuth.api)

    implementation(projects.androidApp.coreUiCompose.api)
    implementation(projects.androidApp.coreNavigation.api)
    implementation(projects.androidApp.featureList.api)

    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.lifecycle.lifecycleRuntimeKtx)
    implementation(libs.retrofit)
    debugImplementation(libs.androidx.compose.uiTooling)
    implementation(libs.androidx.compose.uiToolingPreview)
}
