plugins {
    id("io.github.vichid.library")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreNavigation.api)
}
