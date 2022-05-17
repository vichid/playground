import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.playground.buildlogic.AndroidConfiguration.configureAndroid

plugins {
    id("com.android.library")
    kotlin("android")
    id("com.playground.buildlogic.convention.kotlin")
}

plugins.withType<LibraryPlugin> {
    extensions.getByType<LibraryExtension>().configureAndroid(providers)
}
