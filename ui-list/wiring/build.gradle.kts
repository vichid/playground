plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.anvil")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.uiList.impl)
}

anvil {
    generateDaggerFactories.set(true)
}
