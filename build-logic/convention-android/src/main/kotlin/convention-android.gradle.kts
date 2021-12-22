import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

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
                warningsAsErrors = true
                checkDependencies = true
                checkReleaseBuilds = false
                abortOnError = true
                ignoreTestSources = true
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

fun getAndroidConf(providers: ProviderFactory): AndroidConf {
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

data class AndroidConf(
    val compileSdk: Int?,
    val minSdk: Int?,
    val targetSdk: Int?
)
