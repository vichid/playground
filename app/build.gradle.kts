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

    implementation(projects.coreDi.api)
    implementation(projects.coreUiCompose.api)
    implementation(projects.libNavigation.impl)
    implementation(projects.libLaunch.impl)
    implementation(projects.libLogger.impl)
    implementation(projects.uiSignIn.impl)
    implementation(projects.dataSignIn.impl)
    implementation(projects.uiList.impl)

    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.dagger)

    debugImplementation(libs.leakcanary)

    kapt(libs.dagger.compiler)
}
