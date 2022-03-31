plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(libs.kotlin.coroutines)
    api(libs.kotlin.coroutines.android)
}
