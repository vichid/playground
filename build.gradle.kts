buildscript {
    dependencies {
        classpath(libs.gradlePlugins.junit5)
        classpath(libs.gradlePlugins.buildLogic)
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

apply(plugin = "com.playground.buildlogic.root")
