plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(projects.coreDi)
    api(projects.dataSignIn.api)
}
