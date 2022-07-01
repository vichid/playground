plugins {
    id("io.github.vichid.application.compose")
}

android {
    defaultConfig {
        applicationId = "com.example.playground.loginscreen"
        namespace = "com.example.playground.loginscreen"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    implementation(projects.androidApp.coreUiCompose.api)
    implementation(projects.androidApp.coreNavigation.impl)
    implementation(projects.androidApp.coreNetwork.impl)
    implementation(projects.androidApp.featureAuth.impl)

    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.dagger)

    debugImplementation(libs.leakcanary)

    kapt(libs.dagger.compiler)
}
