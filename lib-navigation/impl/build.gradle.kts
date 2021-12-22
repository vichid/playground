plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
    id("de.mannodermaus.android-junit5")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.libNavigation.api)

    implementation(libs.androidx.compose.navigation)
    implementation(libs.kotlin.coroutines.android)
    implementation(libs.inject)

    testRuntimeOnly(libs.jupiter.engine)
    testImplementation(libs.bundles.unitTests)
}