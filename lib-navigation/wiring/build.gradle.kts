plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.libNavigation.impl)
}

anvil {
    generateDaggerFactories.set(true)
}
