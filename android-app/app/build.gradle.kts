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

    implementation(projects.androidApp.coreDi.api)
    implementation(projects.androidApp.coreUiCompose.api)
    implementation(projects.androidApp.coreNavigation.impl)
    implementation(projects.androidApp.coreAppStart.impl)
    implementation(projects.androidApp.coreLogger.impl)
    implementation(projects.androidApp.featureAuth.impl)
    implementation(projects.androidApp.featureList.impl)

    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.dagger)

    debugImplementation(libs.leakcanary)

    kapt(libs.dagger.compiler)
}
