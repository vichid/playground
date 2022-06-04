plugins {
    id("io.github.vichid.application.compose")
}

android {
    defaultConfig {
        applicationId = "com.example.playground"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(libs.androidx.profileinstaller)
    implementation(libs.dagger)

    debugImplementation(libs.leakcanary)

    kapt(libs.dagger.compiler)
}
