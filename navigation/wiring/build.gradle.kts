plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(projects.navigation.impl)

    implementation(libs.bundles.hilt)

    kapt(libs.bundles.hiltKapt)
}