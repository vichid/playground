plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
    id("de.mannodermaus.android-junit5")
}

dependencies {
    implementation(projects.base.di)
    api(projects.launch.api)
    implementation(projects.navigation.api)
    implementation(projects.signIn.screen.api)

    implementation(libs.inject)

    testRuntimeOnly(libs.jupiter.engine)
    testImplementation(libs.bundles.unitTests)
}
