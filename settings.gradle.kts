pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
plugins {
    id("com.gradle.enterprise") version "3.6.1"
}

gradleEnterprise {
    buildScan {
        termsOfServiceAgree = "yes"
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
    }
}

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Playground"

include(":app")
include(":login")
include(":ui-components")
