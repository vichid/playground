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
    api(projects.loginScreen.api)

    implementation(projects.commonUiCompose)
    implementation(projects.navigation.api)

    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.hilt)

    implementation(libs.androidx.hilt.hiltNavigationCompose)
}
