plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.uiSignIn.impl)

    implementation(projects.libNavigation.api)
}

anvil {
    generateDaggerFactories.set(true)
}
