plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.dataSignIn.impl)
}

anvil {
    generateDaggerFactories.set(true)
}
