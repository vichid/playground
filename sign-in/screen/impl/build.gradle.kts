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
    api(projects.signIn.screen.api)

    implementation(projects.base.uiCompose)
    implementation(projects.navigation.api)
    implementation(projects.signIn.data.api)

    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.hilt)

    implementation(libs.androidx.hilt.hiltNavigationCompose)
}
