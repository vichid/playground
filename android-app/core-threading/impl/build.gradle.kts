plugins {
    id("com.playground.buildlogic.library")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreThreading.api)

    implementation(libs.anvil.annotations)
    implementation(libs.inject.annotations)
    api(libs.kotlin.coroutines)
}
