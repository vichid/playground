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
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.uiSignIn.api)

    implementation(projects.androidApp.coreUiCompose.api)
    implementation(projects.androidApp.libNavigation.api)
    implementation(projects.androidApp.dataSignIn.api)
    implementation(projects.androidApp.uiList.api)

    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.lifecycle.lifecycleRuntimeKtx)
    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
}
