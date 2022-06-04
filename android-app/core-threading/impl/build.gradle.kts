plugins {
    id("io.github.vichid.library")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreThreading.api)

    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
    api(libs.kotlin.coroutines)
}
