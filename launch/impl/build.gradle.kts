plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.base.di)
    api(projects.launch.api)
    implementation(projects.navigation.api)
    implementation(projects.signIn.screen.api)

    implementation(libs.inject)
}
