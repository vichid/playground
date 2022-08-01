buildscript {
    dependencies {
        classpath(libs.gradlePlugins.buildPlugin)
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
