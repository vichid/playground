plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.base.di)
    api(projects.launch.impl)

    implementation(libs.dagger)
}

anvil {
    generateDaggerFactories.set(true)
}
