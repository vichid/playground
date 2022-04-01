plugins {
    id("com.android.library")
    kotlin("android")
    id("de.mannodermaus.android-junit5")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi.api)
    api(projects.libNavigation.api)

    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
    implementation(libs.kotlin.coroutines.android)

    testRuntimeOnly(libs.jupiter.engine)
    testImplementation(libs.bundles.unitTests)
}
