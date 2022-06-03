import org.gradle.kotlin.dsl.withType

plugins {
    id("org.jlleitschuh.gradle.ktlint")
}
val libs: VersionCatalog =
    project.extensions.getByType<VersionCatalogsExtension>().named("libs")

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    android.set(true)
    version.set(libs.findVersion("ktlint").get().toString())
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        allWarningsAsErrors = true
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + listOf("-opt-in=kotlin.RequiresOptIn")

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
