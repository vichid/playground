plugins {
    id("com.playground.buildlogic.library")
}

dependencies {
    implementation(projects.androidApp.coreNavigation.api)
}
