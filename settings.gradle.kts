rootProject.name = "Playground"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    includeBuild("./build-logic")
}
plugins {
    id("com.gradle.enterprise") version "3.8"
}

gradleEnterprise {
    buildScan {
        termsOfServiceAgree = "yes"
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
    }
}

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":lib-auth-status:api")
include(":lib-auth-status:impl")
include(":lib-auth-status:wiring")
include(":lib-navigation:api")
include(":lib-navigation:impl")
include(":lib-navigation:wiring")
include(":data-sign-in:api")
include(":data-sign-in:impl")
include(":data-sign-in:wiring")
include(":ui-sign-in:api")
include(":ui-sign-in:demo")
include(":ui-sign-in:fakes")
include(":ui-sign-in:impl")
include(":ui-sign-in:wiring")
include(":core-ui-compose")
include(":lib-launch:api")
include(":lib-launch:impl")
include(":lib-launch:wiring")
include(":lib-logger:api")
include(":lib-logger:impl")
include(":lib-logger:wiring")
include(":core-di")
include(":ui-list:api")
include(":ui-list:impl")
include(":ui-list:wiring")
