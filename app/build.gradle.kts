plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
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

    implementation(projects.base.uiCompose)
    implementation(projects.navigation.wiring)
    implementation(projects.launch.wiring)
    implementation(projects.signIn.screen.wiring)
    implementation(projects.signIn.data.wiring)

    implementation(libs.bundles.compose)
    implementation(libs.bundles.hilt)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.hilt.hiltNavigationCompose)

    kapt(libs.bundles.hiltKapt)
}
