plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(projects.logger.api)

    implementation(libs.bundles.hilt)

    implementation(libs.timber)
}
