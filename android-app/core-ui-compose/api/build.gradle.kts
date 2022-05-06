plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
}

dependencies {

    implementation(libs.androidx.compose.compiler)
    api(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.uiToolingPreview)
}
