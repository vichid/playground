plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "com.example.playground"
        minSdk = 26
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    lint {
        isWarningsAsErrors = true
        isCheckDependencies = true
        isCheckReleaseBuilds = false
        isAbortOnError = true
        isIgnoreTestSources = true
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
