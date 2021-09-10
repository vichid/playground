plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(projects.loginScreen.impl)

    implementation(projects.navigation.api)

    implementation(libs.bundles.hilt)

    kapt(libs.bundles.hiltKapt)
}
