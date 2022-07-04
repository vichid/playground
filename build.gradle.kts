buildscript {
    dependencies {
        classpath(libs.gradlePlugins.junit5)
        classpath(libs.gradlePlugins.buildLogic)
        classpath(libs.gradlePlugins.android)
        classpath(libs.gradlePlugins.anvil)
        classpath(libs.gradlePlugins.autoManifest)
        classpath(libs.gradlePlugins.detekt)
        classpath(libs.gradlePlugins.kotlin)
        classpath(libs.gradlePlugins.kover)
        classpath(libs.gradlePlugins.ksp)
        classpath(libs.gradlePlugins.paparazzi)
    }

    repositories {
        google()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        maven("https://maven.pkg.github.com/vichid/playground") {
            credentials {
                username = "vichid"
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

apply(plugin = "io.github.vichid.root")
