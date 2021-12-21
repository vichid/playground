plugins {
    `kotlin-dsl`
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath(libs.gradlePlugins.spotless)
    }
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
