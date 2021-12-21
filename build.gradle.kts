buildscript {
    dependencies {
        classpath(libs.gradlePlugins.android)
        classpath(libs.gradlePlugins.kotlin)
        classpath(libs.gradlePlugins.junit5)
    }

    repositories {
        google()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.anvil)
    alias(libs.plugins.doctor)
    alias(libs.plugins.kover)
    id("convention-versioning")
    id("convention-android")
    id("convention-analyzers")
    id("convention-monitoring")
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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            allWarningsAsErrors = true
            freeCompilerArgs = listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
            )
        }
    }
    repositories {
        google()
        mavenCentral()
    }
}
