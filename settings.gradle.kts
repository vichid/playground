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
    id("com.dropbox.focus") version "0.4.0"
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

configure<com.dropbox.focus.FocusExtension> {
    this.allSettingsFileName.set("modules.gradle.kts")
}
