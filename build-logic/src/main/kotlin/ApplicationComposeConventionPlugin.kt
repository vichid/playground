import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import io.github.vichid.ComposeConfiguration.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class ApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.github.vichid.application")
            }

            extensions.getByType<BaseAppModuleExtension>()
                .configureCompose(project)
        }
    }
}
