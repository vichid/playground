plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(libs.anvil.annotations)
    api(libs.dagger)
}
