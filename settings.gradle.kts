rootProject.name = "Playground"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
plugins {
    id("com.gradle.enterprise") version "3.9"
}
val isCiServer = System.getenv().containsKey("CI")

if (isCiServer) {
    gradleEnterprise {
        buildScan {
            termsOfServiceAgree = "yes"
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            tag("CI")
        }
    }
}

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

apply(from = "modules.gradle.kts")
