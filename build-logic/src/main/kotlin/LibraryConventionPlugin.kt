import com.android.build.gradle.LibraryExtension
import com.squareup.anvil.plugin.AnvilExtension
import io.github.vichid.AndroidConfiguration.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("io.github.vichid.kotlin")
                withPlugin("com.squareup.anvil") {
                    extensions.configure<AnvilExtension> {
                        generateDaggerFactories.set(true)
                    }
                }
            }

            extensions.getByType<LibraryExtension>().configureAndroid(providers)
        }
    }
}
