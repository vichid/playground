plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(projects.navigation.api)

    implementation(libs.androidx.hilt.hiltNavigationCompose)
}
