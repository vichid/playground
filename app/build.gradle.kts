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

    implementation(projects.coreDi)
    implementation(projects.coreUiCompose)
    implementation(projects.libNavigation.wiring)
    implementation(projects.libLaunch.wiring)
    implementation(projects.libLogger.wiring)
    implementation(projects.uiSignIn.wiring)
    implementation(projects.dataSignIn.wiring)
    implementation(projects.uiList.wiring)

    implementation(libs.bundles.compose)
    implementation(libs.dagger)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.navigation)

    debugImplementation(libs.leakcanary)

    kapt(libs.dagger.compiler)
}
