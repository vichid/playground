plugins {
    id("io.github.vichid.library")
}

dependencies {
    implementation(projects.androidApp.coreDi.api)

    implementation(libs.androidx.lifecycle.viewmodelCompose)
    implementation(libs.androidx.lifecycle.viewmodelSavedState)
    implementation(libs.dagger)
}
