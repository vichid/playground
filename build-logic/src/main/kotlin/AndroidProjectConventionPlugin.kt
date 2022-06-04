import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

class AndroidProjectConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.autonomousapps.dependency-analysis")
                apply("com.osacky.doctor")
                apply("com.github.ben-manes.versions")
                apply("io.github.vichid.module")
                apply("com.jraska.module.graph.assertion")
                apply("org.jetbrains.kotlinx.kover")
            }

            fun String.isNonStable(): Boolean {
                val stableKeyword =
                    listOf("RELEASE", "FINAL", "GA").any { toUpperCase().contains(it) }
                val regex = "^[0-9,.v-]+(-r)?$".toRegex()
                val isStable = stableKeyword || regex.matches(this)
                return isStable.not()
            }

            tasks.withType<DependencyUpdatesTask> {
                rejectVersionIf {
                    candidate.version.isNonStable()
                }

                checkForGradleUpdate = true
                outputFormatter = "json"
                outputDir = "build/dependencyUpdates"
                reportfileName = "report"
            }

            extensions.configure<com.jraska.module.graph.assertion.GraphRulesExtension> {
                maxHeight = 4
                allowed = arrayOf(
                    ":android-app:app -> :android-app:.*:impl",
                    ":android-app:.*:demo -> :android-app:.*:impl",
                    ":android-app:.* -> :android-app:core.*",
                    ":android-app:.*:impl -> :android-app:.*:api",
                )
                restricted = arrayOf(
                    ":android-app:.*:impl -X> :android-app:.*:impl",
                )
            }
        }
    }
}
