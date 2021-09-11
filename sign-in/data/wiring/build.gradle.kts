plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(projects.signIn.data.impl)

    implementation(libs.bundles.hilt)

    kapt(libs.bundles.hiltKapt)
}
