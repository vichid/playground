plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(projects.coreDi.api)
    api(projects.dataSignIn.api)
}
