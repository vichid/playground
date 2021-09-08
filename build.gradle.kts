buildscript {
    dependencies {
        @Suppress("UnstableApiUsage") val libs =
            project.extensions.getByType<VersionCatalogsExtension>()
                .named("libs") as org.gradle.accessors.dm.LibrariesForLibs
        classpath(libs.gradlePlugins.android)
        classpath(libs.gradlePlugins.kotlin)
        classpath(libs.gradlePlugins.versionsBenManes)
        classpath(libs.gradlePlugins.spotless)
        classpath(libs.gradlePlugins.hilt)
    }

    repositories {
        google()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

apply {
    from(rootProject.file("gradle/spotless-config.gradle"))
    from(rootProject.file("gradle/dependencyGraph.gradle"))
}
plugins {
    id("com.github.ben-manes.versions") version "0.39.0"
    id("com.osacky.doctor") version "0.7.1"
    id("common.android.configuration")
    id("app.versioning")
}

fun String.isNonStable(): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(this)
    return isStable.not()
}

tasks {
    withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {

        rejectVersionIf {
            candidate.version.isNonStable()
        }

        checkForGradleUpdate = true
        outputFormatter = "json"
        outputDir = "build/dependencyUpdates"
        reportfileName = "report"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            // Treat all Kotlin warnings as errors
            allWarningsAsErrors = true

            // Enable experimental coroutines APIs, including Flow
            freeCompilerArgs.plus("-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi")
            freeCompilerArgs.plus("-Xopt-in=kotlinx.coroutines.FlowPreview")
            freeCompilerArgs.plus("-Xopt-in=kotlin.Experimental")
        }
    }
}

doctor {
    warnWhenNotUsingParallelGC.set(false)
    javaHome {
        ensureJavaHomeMatches.set(false)
    }
}

allprojects {
    buildscript {
        repositories {
            google()
            maven {
                url = uri("https://plugins.gradle.org/m2/")
            }
        }
    }

    repositories {
        google()
        mavenCentral()
    }
}
