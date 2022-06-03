rootProject.name = "full-playground"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    includeBuild("./build-logic")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.gradle.enterprise") version "3.10.1"
    id("com.dropbox.focus") version "0.5.1"
    id("com.gradle.common-custom-user-data-gradle-plugin") version "1.7.1"
}

val isCI = System.getenv().containsKey("CI")

gradleEnterprise {
    server = "https://ge.gradle.org/"
    buildScan {
        termsOfServiceAgree = "yes"
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        tag("CI")
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
    this.allSettingsFileName.set("android-app/modules.gradle.kts")
}
