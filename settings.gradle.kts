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
include(":common-ui-compose")
include(":login-screen:api")
include(":login-screen:impl")
include(":login-screen:wiring")
include(":login-screen:fakes")
include(":login-screen:demo")
include(":navigation:api")
include(":navigation:impl")
include(":navigation:wiring")
include(":login-status:api")
include(":login-status:impl")
include(":login-status:wiring")
