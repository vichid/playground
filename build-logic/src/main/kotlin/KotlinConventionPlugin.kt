import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

class KotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jlleitschuh.gradle.ktlint")

                val libs: VersionCatalog =
                    project.extensions.getByType<VersionCatalogsExtension>().named("libs")

                extensions.configure<KtlintExtension> {
                    android.set(true)
                    version.set(libs.findVersion("ktlint").get().toString())
                }

                tasks.withType<KotlinCompile> {
                    kotlinOptions {
                        allWarningsAsErrors = true
                        kotlinOptions {
                            freeCompilerArgs =
                                freeCompilerArgs + listOf("-opt-in=kotlin.RequiresOptIn")

                            if (project.findProperty("playground.enableComposeCompilerReports") == "true") {
                                freeCompilerArgs = freeCompilerArgs +
                                    listOf(
                                        "-P",
                                        "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
                                            project.buildDir.absolutePath + "/compose_metrics"
                                    ) +
                                    listOf(
                                        "-P",
                                        "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
                                            project.buildDir.absolutePath + "/compose_metrics"
                                    )
                            }
                        }
                    }
                }
            }
        }
    }
}
