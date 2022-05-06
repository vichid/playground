plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.dataSignIn.api)

    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
}
