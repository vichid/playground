buildscript {
    dependencies {
        classpath(libs.gradlePlugins.junit5)
        classpath(libs.gradlePlugins.buildLogic)
    }

    repositories {
        google()
        maven("https://jitpack.io")
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.anvil)
    // id("android-build-logic") apply false
}
apply(plugin = "android-build-logic")

subprojects {
    repositories {
        google()
        mavenCentral()
    }
}
