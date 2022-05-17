plugins {
    id("com.playground.buildlogic.library.compose")
}

dependencies {

    implementation(libs.androidx.compose.compiler)
    api(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.uiToolingPreview)
}
