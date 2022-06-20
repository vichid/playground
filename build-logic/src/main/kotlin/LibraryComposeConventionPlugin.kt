import io.github.vichid.ComposeConfiguration.configureComposeLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.withType

class LibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.github.vichid.library")
                withPlugin("io.github.vichid.library", configureComposeLibrary())
                apply("app.cash.paparazzi")
            }

            tasks.withType<Test>().configureEach {
                this.jvmArgs("--add-opens=java.base/java.lang.reflect=ALL-UNNAMED")
            }
        }
    }
}
