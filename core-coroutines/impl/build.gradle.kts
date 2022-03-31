plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(projects.coreDi.api)
    api(projects.coreCoroutines.api)

    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
    api(libs.kotlin.coroutines)
}
