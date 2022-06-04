import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.autonomousapps.dependency-analysis")
    id("com.osacky.doctor")
    id("com.github.ben-manes.versions")
    id("com.playground.buildlogic.module-generator")
    id("com.jraska.module.graph.assertion")
    id("org.jetbrains.kotlinx.kover")
}

fun String.isNonStable(): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { toUpperCase().contains(it) }
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

configure<com.jraska.module.graph.assertion.GraphRulesExtension> {
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
