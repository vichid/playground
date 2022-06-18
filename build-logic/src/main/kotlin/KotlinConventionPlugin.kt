import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_SRC_DIR_JAVA
import io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_SRC_DIR_KOTLIN
import io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_TEST_SRC_DIR_JAVA
import io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_TEST_SRC_DIR_KOTLIN
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.registering
import org.gradle.kotlin.dsl.withType

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

            val libs: VersionCatalog =
                project.extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "detektPlugins"(libs.findLibrary("detekt.formatting").get().get())
                "detektPlugins"(libs.findLibrary("detekt.custom.rules").get().get())
            }
        }
    }
}
