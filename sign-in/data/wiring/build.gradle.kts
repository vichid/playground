plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.base.di)
    api(projects.signIn.data.impl)
}

anvil {
    generateDaggerFactories.set(true)
}
