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
    implementation(projects.coreDi)
    api(projects.uiList.api)

    implementation(projects.coreUiCompose)
    implementation(projects.libNavigation.api)

    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)

    implementation(libs.androidx.compose.navigation)
    implementation(libs.inject)
}