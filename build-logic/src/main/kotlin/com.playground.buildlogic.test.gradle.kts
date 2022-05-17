import com.android.build.gradle.TestExtension
import com.android.build.gradle.TestPlugin
import com.playground.buildlogic.AndroidConfiguration.configureAndroid

plugins {
    id("com.android.test")
    kotlin("android")
    id("com.playground.buildlogic.convention.kotlin")
}

plugins.withType<TestPlugin> {
    extensions.getByType<TestExtension>().configureAndroid(providers)
}
