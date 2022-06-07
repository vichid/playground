import com.squareup.anvil.plugin.AnvilExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class JvmConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
                apply("io.github.vichid.kotlin")
                withPlugin("com.squareup.anvil") {
                    extensions.configure<AnvilExtension> {
                        generateDaggerFactories.set(true)
                    }
                }
            }
        }
    }
}
