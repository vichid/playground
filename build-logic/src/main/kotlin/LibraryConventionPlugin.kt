import com.android.build.gradle.LibraryExtension
import io.github.vichid.AndroidConfiguration.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("io.github.vichid.kotlin")
            }

            extensions.getByType<LibraryExtension>().configureAndroid(providers)
        }
    }
}
