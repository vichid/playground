import io.github.vichid.ComposeConfiguration.configureComposeApp
import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.github.vichid.application")
                withPlugin("io.github.vichid.application", configureComposeApp())
            }
        }
    }
}
