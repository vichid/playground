plugins {
    id("io.github.vichid.library")
    id("de.mannodermaus.android-junit5")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreNavigation.api)

    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
    implementation(libs.kotlin.coroutines.android)

    testRuntimeOnly(libs.jupiter.engine)
    testImplementation(libs.bundles.unitTests)
}
