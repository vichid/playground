plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(projects.androidApp.libNavigation.api)
}
