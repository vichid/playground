plugins {
    id("io.github.vichid.library")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)
    api(projects.androidApp.coreAppStart.api)
    implementation(projects.androidApp.coreNavigation.api)
    implementation(projects.androidApp.featureScreenTopA.api)

    implementation(libs.androidx.startup.runtime)
}
