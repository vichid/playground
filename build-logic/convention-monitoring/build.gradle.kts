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
        classpath(libs.gradlePlugins.moduleGraphAssertion)
    }
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.gradlePlugins.versionUpdate)
    implementation(libs.gradlePlugins.moduleGraphAssertion)
}
