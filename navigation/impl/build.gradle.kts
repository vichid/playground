plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
    id("de.mannodermaus.android-junit5")
}

dependencies {
    implementation(projects.base.di)
    api(projects.navigation.api)

    implementation(libs.androidx.navigation.navigationCompose)
    implementation(libs.kotlin.coroutines.android)
    implementation(libs.inject)

    testRuntimeOnly(libs.jupiter.engine)
    testImplementation(libs.bundles.unitTests)
}
