plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(projects.signIn.data.api)
}
