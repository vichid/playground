plugins {
    id("io.github.vichid.application.compose")
}

android {
    defaultConfig {
        applicationId = "com.example.playground.coreUiCompose"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.androidApp.coreUiCompose.api)

    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui)
}
