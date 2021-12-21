plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.libLaunch.impl)

    implementation(libs.dagger)
}

anvil {
    generateDaggerFactories.set(true)
}
