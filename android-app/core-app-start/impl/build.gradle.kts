plugins {
    id("io.github.vichid.library")
    id("de.mannodermaus.android-junit5")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreAppStart.api)
    implementation(projects.androidApp.coreNavigation.api)
    implementation(projects.androidApp.featureAuth.api)

    implementation(libs.androidx.startup.runtime)

    testRuntimeOnly(libs.jupiter.engine)
    testImplementation(libs.bundles.unitTests)
}
