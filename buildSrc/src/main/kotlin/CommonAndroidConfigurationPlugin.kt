package com.playground

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.ProviderFactory
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

class CommonAndroidConfigurationPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.subprojects {
            plugins.withType<AppPlugin> {
                extensions.getByType<BaseAppModuleExtension>().apply {
                    val androidConf = getAndroidConf(providers)
                    compileSdk = androidConf.compileSdk
                    defaultConfig.minSdk = androidConf.minSdk
                    defaultConfig {
                        targetSdk = androidConf.targetSdk
                    }
                    buildTypes {
                        getByName("debug") {
                            applicationIdSuffix = ".debug"
                            isDefault = true
                        }
                    }
                    lint {
                        isWarningsAsErrors = true
                        isCheckDependencies = true
                        isCheckReleaseBuilds = false
                        isAbortOnError = true
                        isIgnoreTestSources = true
                    }
                }
            }
            plugins.withType<LibraryPlugin> {
                extensions.getByType<LibraryExtension>().apply {
                    val androidConf = getAndroidConf(providers)
                    compileSdk = androidConf.compileSdk
                    defaultConfig.minSdk = androidConf.minSdk
                }
            }
        }
    }

    private fun getAndroidConf(providers: ProviderFactory): AndroidConf {
        val compileSdk = providers.gradleProperty("android.compileSdk")
            .forUseAtConfigurationTime()
            .map { it.toInt() }
            .orNull
        val minSdk = providers.gradleProperty("android.minSdk")
            .forUseAtConfigurationTime()
            .map { it.toInt() }
            .orNull
        val targetSdk = providers.gradleProperty("android.targetSdk")
            .forUseAtConfigurationTime()
            .map { it.toInt() }
            .orNull
        return AndroidConf(compileSdk, minSdk, targetSdk)
    }

    private data class AndroidConf(
        val compileSdk: Int?,
        val minSdk: Int?,
        val targetSdk: Int?
    )
}
