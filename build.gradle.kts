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
    id("com.playground.buildlogic.root") apply false
}

apply(plugin = "com.playground.buildlogic.root")
