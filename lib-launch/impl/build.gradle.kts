plugins {
    id("com.android.library")
    kotlin("android")
    id("de.mannodermaus.android-junit5")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi.api)
    api(projects.libLaunch.api)
    implementation(projects.libNavigation.api)
    implementation(projects.uiSignIn.api)

    implementation(libs.androidx.startup.runtime)
    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)

    testRuntimeOnly(libs.jupiter.engine)
    testImplementation(libs.bundles.unitTests)
}
