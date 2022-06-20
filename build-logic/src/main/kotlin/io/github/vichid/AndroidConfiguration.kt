package io.github.vichid

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.TestExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.api.plugins.AppliedPlugin
import org.gradle.api.provider.ProviderFactory
import org.gradle.kotlin.dsl.getByType

object AndroidConfiguration {

    fun Project.configureAppAndroid(): (AppliedPlugin).() -> Unit =
        {
            extensions.getByType<BaseAppModuleExtension>().apply {
                configureAndroid(providers)
                configureApp()
            }
        }

    fun Project.configureLibraryAndroid(): (AppliedPlugin).() -> Unit =
        {
            extensions.getByType<LibraryExtension>().configureAndroid(providers)
        }

    fun Project.configureTestAndroid(): (AppliedPlugin).() -> Unit =
        {
            extensions.getByType<TestExtension>().configureAndroid(providers)
        }

    private fun getAndroidConf(providers: ProviderFactory): AndroidConf {
        val compileSdk = providers.gradleProperty("android.compileSdk")
            .map { it.toInt() }
            .orNull
        val minSdk = providers.gradleProperty("android.minSdk")
            .map { it.toInt() }
            .orNull
        val targetSdk = providers.gradleProperty("android.targetSdk")
            .map { it.toInt() }
            .orNull
        return AndroidConf(compileSdk, minSdk, targetSdk)
    }

    @Suppress("UnstableApiUsage")
    private fun CommonExtension<*, *, *, *>.configureAndroid(providers: ProviderFactory) {
        val androidConf = getAndroidConf(providers)
        compileSdk = androidConf.compileSdk
        defaultConfig.minSdk = androidConf.minSdk
        defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        when (this) {
            is BaseAppModuleExtension -> defaultConfig.targetSdk = androidConf.targetSdk
        }
    }

    @Suppress("UnstableApiUsage")
    private fun BaseAppModuleExtension.configureApp() {
        buildTypes {
            getByName("debug") {
                applicationIdSuffix = ".debug"
                isDefault = true
            }
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
                signingConfig = signingConfigs.getByName("debug")
            }
        }
        lint {
            warningsAsErrors = true
            checkDependencies = true
            checkReleaseBuilds = false
            abortOnError = true
            ignoreTestSources = true
        }
    }

    data class AndroidConf(
        val compileSdk: Int?,
        val minSdk: Int?,
        val targetSdk: Int?
    )
}
