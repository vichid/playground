plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
    id("de.mannodermaus.android-junit5")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.libLaunch.api)
    implementation(projects.libNavigation.api)
    implementation(projects.uiSignIn.api)

    implementation(libs.androidx.startup.runtime)

    testRuntimeOnly(libs.jupiter.engine)
    testImplementation(libs.bundles.unitTests)
}
