import io.github.vichid.AndroidConfiguration.configureLibraryAndroid
import io.github.vichid.AnvilConfiguration.configureAnvil
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                withPlugin("com.android.library", configureLibraryAndroid())
                apply("org.jetbrains.kotlin.android")
                apply("io.github.vichid.kotlin")
                withPlugin("com.squareup.anvil", configureAnvil())
            }
        }
    }
}
