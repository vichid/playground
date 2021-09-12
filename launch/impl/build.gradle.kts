plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(projects.launch.api)

    implementation(libs.bundles.hilt)
}
