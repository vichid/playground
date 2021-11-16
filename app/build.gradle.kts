plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.squareup.anvil")
}

android {
    defaultConfig {
        applicationId = "com.example.playground"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
}

dependencies {

    implementation(projects.base.di)
    implementation(projects.base.uiCompose)
    implementation(projects.navigation.wiring)
    implementation(projects.launch.wiring)
    implementation(projects.logger.wiring)
    implementation(projects.signIn.screen.wiring)
    implementation(projects.signIn.data.wiring)
    implementation(projects.list.screen.wiring)

    implementation(libs.bundles.compose)
    implementation(libs.dagger)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.navigation)

    kapt(libs.dagger.compiler)
}
