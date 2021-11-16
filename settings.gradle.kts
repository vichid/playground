pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
plugins {
    id("com.gradle.enterprise") version "3.7.1"
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
include(":auth-status:api")
include(":auth-status:impl")
include(":auth-status:wiring")
include(":navigation:api")
include(":navigation:impl")
include(":navigation:wiring")
include(":sign-in:data:api")
include(":sign-in:data:impl")
include(":sign-in:data:wiring")
include(":sign-in:screen:api")
include(":sign-in:screen:demo")
include(":sign-in:screen:fakes")
include(":sign-in:screen:impl")
include(":sign-in:screen:wiring")
include(":base:ui-compose")
include(":launch:api")
include(":launch:impl")
include(":launch:wiring")
include(":logger:api")
include(":logger:impl")
include(":logger:wiring")
include(":base:di")
include(":list:screen:api")
include(":list:screen:impl")
include(":list:screen:wiring")
