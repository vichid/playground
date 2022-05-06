plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreCoroutines.api)

    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
    api(libs.kotlin.coroutines)
}
