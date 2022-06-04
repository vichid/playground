import com.android.build.gradle.LibraryExtension
import io.github.vichid.ComposeConfiguration.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class LibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.github.vichid.library")
            }

            extensions.getByType<LibraryExtension>()
                .configureCompose(project)
        }
    }
}
