plugins {
    id("io.github.vichid.jvm")
    id("com.squareup.anvil")
}

dependencies {
    api(projects.androidApp.coreNetwork.api)
    implementation(projects.androidApp.coreDi.api)

    implementation(libs.dagger)
    implementation(libs.inject.annotations)
    implementation(libs.anvil.annotations)
    api(libs.retrofit)
}
