plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(projects.authStatus.api)
}
