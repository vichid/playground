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
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
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
