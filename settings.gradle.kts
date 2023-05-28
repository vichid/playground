rootProject.name = "full-playground"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

if ("build.logic.path" in extra.properties) {
    val path = (extra["build.logic.path"] as String)
    includeBuild(path) {
        dependencySubstitution {
            substitute(module("io.github.vichid:build-plugin"))
                .using(project(":build-plugin"))
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.github.com/vichid/detekt-rules") {
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN_PUBLISH")
            }
        }
        maven("https://maven.pkg.github.com/vichid/android-build-plugin") {
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN_PUBLISH")
            }
        }
    }
}

plugins {
    id("com.gradle.enterprise") version "3.13.3"
    id("com.dropbox.focus") version "0.5.1"
    id("com.gradle.common-custom-user-data-gradle-plugin") version "1.8"
}

val isCI = System.getenv().containsKey("CI")

gradleEnterprise {
    buildScan {
        termsOfServiceAgree = "yes"
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        capture { isTaskInputFiles = true }
        isUploadInBackground = !isCI
        publishAlways()
    }
}

buildCache {
    local {
        isEnabled = true
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

configure<com.dropbox.focus.FocusExtension> {
    this.allSettingsFileName.set("modules.gradle.kts")
}
