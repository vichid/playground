plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
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

    implementation(libs.bundles.compose)
    implementation(libs.bundles.hilt)
    implementation(libs.bundles.lifecycle)
    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.navigation.navigationCompose)
    implementation(libs.androidx.hilt.hiltNavigationCompose)

    kapt(libs.bundles.hiltKapt)
}
