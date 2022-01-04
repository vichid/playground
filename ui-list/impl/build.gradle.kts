plugins {
    id("com.android.library")
    kotlin("android")
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
    api(projects.uiList.api)

    implementation(projects.coreUiCompose.api)
    implementation(projects.libNavigation.api)

    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)

    implementation(libs.androidx.compose.navigation)
}
