plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.base.di)
    api(projects.signIn.screen.impl)

    implementation(projects.navigation.api)
}

anvil {
    generateDaggerFactories.set(true)
}
