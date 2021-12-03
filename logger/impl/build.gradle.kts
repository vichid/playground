plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.base.di)
    api(projects.logger.api)

    implementation(libs.androidx.startup.runtime)
    implementation(libs.inject)
    implementation(libs.timber)
}
