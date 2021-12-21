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
        classpath(libs.gradlePlugins.versionUpdate)
    }
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.gradlePlugins.versionUpdate)
}
