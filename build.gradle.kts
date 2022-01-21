buildscript {
    dependencies {
        classpath(libs.gradlePlugins.android)
        classpath(libs.gradlePlugins.kotlin)
        classpath(libs.gradlePlugins.junit5)
        classpath(libs.gradlePlugins.buildLogic)
    }

    repositories {
        google()
        maven("https://jitpack.io")
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
}
apply(plugin = "android-build-logic")

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
            maven { url = uri("https://plugins.gradle.org/m2/") }
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

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
