plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.libLogger.api)

    implementation(libs.androidx.startup.runtime)
    implementation(libs.timber)
}
