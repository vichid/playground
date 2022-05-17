plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreLogger.api)

    implementation(libs.androidx.startup.runtime)
    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
    implementation(libs.timber)
}
