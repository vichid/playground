package com.playground

import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.gradle.AppPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

class AppVersioningPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.subprojects {
            plugins.withType<AppPlugin> {
                extensions.configure<ApplicationAndroidComponentsExtension> {
                    val major = providers.gradleProperty("app.major")
                        .forUseAtConfigurationTime()
                        .map { it.toInt() }
                        .orNull
                        ?: throw IllegalArgumentException(
                            "Add missing app.major property to your gradle.properties file"
                        )
                    val minor = providers.gradleProperty("app.minor")
                        .forUseAtConfigurationTime()
                        .map { it.toInt() }
                        .orNull
                        ?: throw IllegalArgumentException(
                            "Add missing app.minor property to your gradle.properties file"
                        )
                    val patch = providers.gradleProperty("app.patch")
                        .forUseAtConfigurationTime()
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
        }
    }
}
