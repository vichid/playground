plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.base.di)
    api(projects.list.screen.impl)
}

anvil {
    generateDaggerFactories.set(true)
}
