plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.gradlePlugins.spotless)
    implementation(libs.ktlint)
    implementation(libs.googlejavaformat)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
