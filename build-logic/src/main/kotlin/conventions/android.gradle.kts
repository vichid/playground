package conventions

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.TestExtension
import com.android.build.gradle.TestPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

subprojects {
    plugins.withType<AppPlugin> {
        extensions.getByType<BaseAppModuleExtension>().apply {
            configureAndroid()
            configureApp()
        }
    }
    plugins.withType<LibraryPlugin> {
        extensions.getByType<LibraryExtension>().configureAndroid()
    }
    plugins.withType<TestPlugin> {
        extensions.getByType<TestExtension>().configureAndroid()
    }
}

fun getAndroidConf(providers: ProviderFactory): AndroidConf {
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
fun CommonExtension<*, *, *, *>.configureAndroid() {
    val androidConf = getAndroidConf(providers)
    compileSdk = androidConf.compileSdk
    defaultConfig.minSdk = androidConf.minSdk
    defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    when (this) {
        is BaseAppModuleExtension -> defaultConfig.targetSdk = androidConf.targetSdk
    }
}

@Suppress("UnstableApiUsage")
fun BaseAppModuleExtension.configureApp() {

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
