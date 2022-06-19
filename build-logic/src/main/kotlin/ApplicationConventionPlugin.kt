import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import io.github.vichid.AndroidConfiguration.configureAndroid
import io.github.vichid.AndroidConfiguration.configureApp
import io.github.vichid.AnvilConfiguration.configureAnvil
import io.github.vichid.RulerConfiguration.configureRuler
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class ApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
                apply("io.github.vichid.kotlin")
                apply("com.spotify.ruler")
                withPlugin("com.spotify.ruler", configureRuler())
                apply("com.squareup.anvil")
                withPlugin("com.squareup.anvil", configureAnvil())
            }
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
    }
}
