import com.android.build.api.dsl.TestExtension
import io.github.vichid.AndroidConfiguration.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class TestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
                apply("io.github.vichid.kotlin")
            }
            extensions.getByType<TestExtension>().configureAndroid(providers)
        }
    }
}
