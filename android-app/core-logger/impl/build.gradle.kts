plugins {
    id("io.github.vichid.library")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreLogger.api)

    implementation(libs.androidx.startup.runtime)
    implementation(libs.timber)
}
