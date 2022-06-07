plugins {
    id("io.github.vichid.jvm")
    id("com.squareup.anvil")
}

dependencies {
    api(projects.androidApp.coreNetwork.api)
    implementation(projects.androidApp.coreDi.api)

    api(libs.retrofit)
}
