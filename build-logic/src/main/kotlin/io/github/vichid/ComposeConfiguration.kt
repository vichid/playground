package io.github.vichid

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.registering
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object ComposeConfiguration {

    @Suppress("UnstableApiUsage")
    fun CommonExtension<*, *, *, *>.configureCompose(project: Project) {
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose").get().toString()
        }
        val composeTxtReportMerge by project.tasks.registering(ComposeReportMergeTask::class) {
            output.set(project.rootProject.buildDir.resolve("reports/compose-metrics/merged-composables.txt"))
        }
        val composeCsvReportMerge by project.tasks.registering(ComposeReportMergeTask::class) {
            output.set(project.rootProject.buildDir.resolve("reports/compose-metrics/merged-composables.csv"))
        }
        project.tasks.withType<KotlinCompile> {
            finalizedBy(composeTxtReportMerge)
            finalizedBy(composeCsvReportMerge)
            composeTxtReportMerge.configure {
                input.from("${project.buildDir.absolutePath}/compose-metrics/${project.name}_release-composables.txt")
            }
            composeCsvReportMerge.configure {
                input.from("${project.buildDir.absolutePath}/compose-metrics/${project.name}_release-composables.csv")
            }
            kotlinOptions {
                kotlinOptions {
                    if (project.findProperty("playground.enableComposeCompilerReports") == "true") {
                        freeCompilerArgs = freeCompilerArgs +
                            listOf(
                                "-P",
                                "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
                                    project.buildDir.absolutePath + "/compose-metrics"
                            ) +
                            listOf(
                                "-P",
                                "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
                                    project.buildDir.absolutePath + "/compose-metrics"
                            )
                    }
                }
            }
        }
    }
}
