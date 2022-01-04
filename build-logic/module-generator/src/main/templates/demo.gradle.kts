plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.squareup.anvil")
}

android {
    defaultConfig {
        applicationId = "com.example.playground.$s"

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

    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.navigation)

    debugImplementation(libs.leakcanary)

    kapt(libs.dagger.compiler)
}
