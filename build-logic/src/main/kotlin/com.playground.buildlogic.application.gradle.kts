import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.playground.buildlogic.AndroidConfiguration.configureAndroid
import com.playground.buildlogic.AndroidConfiguration.configureApp

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("org.jlleitschuh.gradle.ktlint")
    id("com.playground.buildlogic.convention.kotlin")
    id("com.squareup.anvil")
}

plugins.withType<AppPlugin> {
    extensions.getByType<BaseAppModuleExtension>().apply {
        configureAndroid(providers)
        configureApp()
    }

    extensions.configure<ApplicationAndroidComponentsExtension> {
        val major = providers.gradleProperty("app.major")
            .map { it.toInt() }
            .orNull
            ?: throw IllegalArgumentException(
                "Add missing app.major property to your gradle.properties file"
            )
        val minor = providers.gradleProperty("app.minor")
            .map { it.toInt() }
            .orNull
            ?: throw IllegalArgumentException(
                "Add missing app.minor property to your gradle.properties file"
            )
        val patch = providers.gradleProperty("app.patch")
            .map { it.toInt() }
            .orNull
            ?: throw IllegalArgumentException(
                "Add missing app.patch property to your gradle.properties file"
            )
        onVariants { variant ->
            variant.outputs.forEach {
                it.versionCode.set(major * 10000 + minor * 100 + patch)
                it.versionName.set("$major.$minor.$patch")
            }
        }
    }
}
