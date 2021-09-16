plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.base.di)
    api(projects.navigation.api)

    implementation(libs.androidx.navigation.navigationCompose)
    implementation(libs.kotlin.coroutines.android)
    implementation(libs.inject)
}
