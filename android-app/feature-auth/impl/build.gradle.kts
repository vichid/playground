plugins {
    id("com.playground.buildlogic.library.compose")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
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
    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
}