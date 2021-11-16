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
    implementation(projects.base.di)
    api(projects.list.screen.api)

    implementation(projects.base.uiCompose)
    implementation(projects.navigation.api)

    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)

    implementation(libs.androidx.compose.navigation)
    implementation(libs.inject)
}