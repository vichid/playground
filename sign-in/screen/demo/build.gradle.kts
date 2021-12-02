plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.squareup.anvil")
}

android {
    defaultConfig {
        applicationId = "com.example.playground.loginscreen"

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
    implementation(projects.signIn.screen.wiring)

    implementation(libs.bundles.compose)
    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.navigation.navigationCompose)
    implementation(libs.dagger)

    debugImplementation(libs.leakcanary)

    kapt(libs.dagger.compiler)
}
