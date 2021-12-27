plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.[moduleName].impl)
}

anvil {
    generateDaggerFactories.set(true)
}
