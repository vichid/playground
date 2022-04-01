plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
}

dependencies {
    implementation(projects.coreDi.api)
    api(projects.uiSignIn.api)

    implementation(projects.coreUiCompose.api)
    implementation(projects.libNavigation.api)
    implementation(projects.dataSignIn.api)
    implementation(projects.uiList.api)

    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.lifecycle.lifecycleRuntimeKtx)
    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
}
