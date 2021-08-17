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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.appCompat)

    kapt(libs.bundles.hiltKapt)
}
