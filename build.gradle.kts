buildscript {
    dependencies {
        classpath(libs.gradlePlugins.junit5)
        classpath(libs.gradlePlugins.buildPlugin)
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
        gradlePluginPortal()
        maven("https://maven.pkg.github.com/vichid/android-build-plugin") {
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN_PUBLISH")
            }
        }
    }
}

apply(plugin = "io.github.vichid.root")
