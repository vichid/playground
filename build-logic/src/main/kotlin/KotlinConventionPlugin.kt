import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_SRC_DIR_JAVA
import io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_SRC_DIR_KOTLIN
import io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_TEST_SRC_DIR_JAVA
import io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_TEST_SRC_DIR_KOTLIN
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.registering
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }

            tasks.withType<Detekt>().configureEach {
                config.setFrom(file("$rootDir/config/detekt/detekt.yml"))
                buildUponDefaultConfig = true
                reports {
                    xml.required.set(true)
                    sarif.required.set(true)
                }
                source(
                    objects.fileCollection().from(
                        DEFAULT_SRC_DIR_JAVA,
                        DEFAULT_TEST_SRC_DIR_JAVA,
                        DEFAULT_SRC_DIR_KOTLIN,
                        DEFAULT_TEST_SRC_DIR_KOTLIN,
                    )
                )
            }

            val reportXmlMerge by tasks.registering(io.gitlab.arturbosch.detekt.report.ReportMergeTask::class) {
                output.set(rootProject.buildDir.resolve("reports/detekt/merge.xml"))
            }
            val reportSarifMerge by tasks.registering(io.gitlab.arturbosch.detekt.report.ReportMergeTask::class) {
                output.set(rootProject.buildDir.resolve("reports/detekt/merge.sarif"))
            }
            plugins.withType<DetektPlugin> {
                tasks.withType<Detekt> {
                    finalizedBy(reportXmlMerge)
                    finalizedBy(reportSarifMerge)

                    reportXmlMerge.configure {
                        input.from(xmlReportFile)
                    }
                    reportSarifMerge.configure {
                        input.from(sarifReportFile)
                    }
                }
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
