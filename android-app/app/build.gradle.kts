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
    implementation(projects.androidApp.coreDiUtils.api)
    implementation(projects.androidApp.coreUiCompose.api)
    implementation(projects.androidApp.coreNavigation.impl)
    implementation(projects.androidApp.coreAppStart.impl)
    implementation(projects.androidApp.coreLogger.impl)
    implementation(projects.androidApp.coreNetwork.impl)
    implementation(projects.androidApp.coreThreading.impl)
    implementation(projects.androidApp.featureAuth.impl)
    implementation(projects.androidApp.featureList.impl)
    implementation(projects.androidApp.featureScreenTopA.impl)
    implementation(projects.androidApp.featureScreenTopB.impl)
    implementation(projects.androidApp.featureScreenChildA.impl)
    implementation(projects.androidApp.featureScreenChildB.impl)

    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.core.splashScreen)
    implementation(libs.androidx.profileinstaller)

    debugImplementation(libs.leakcanary)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}
