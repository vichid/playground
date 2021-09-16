plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.base.di)
    api(projects.logger.impl)
}

anvil {
    generateDaggerFactories.set(true)
}
