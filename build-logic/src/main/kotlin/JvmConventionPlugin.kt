import com.squareup.anvil.plugin.AnvilExtension
import io.github.vichid.AnvilConfiguration.configureAnvil
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class JvmConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
                apply("io.github.vichid.kotlin")
                withPlugin("com.squareup.anvil", configureAnvil())
            }
        }
    }
}
