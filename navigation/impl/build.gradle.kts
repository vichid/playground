plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {

    api(projects.navigation.api)

    implementation(libs.bundles.hilt)

    implementation(libs.androidx.navigation.navigationCompose)
    implementation(libs.kotlin.coroutines.android)
}
