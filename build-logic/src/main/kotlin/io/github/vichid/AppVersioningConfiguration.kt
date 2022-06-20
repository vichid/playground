package io.github.vichid

import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import org.gradle.api.Project
import org.gradle.api.plugins.AppliedPlugin
import org.gradle.kotlin.dsl.configure

object AppVersioningConfiguration {
    fun Project.configureAppVersioning(): (AppliedPlugin).() -> Unit =
        {
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
}
