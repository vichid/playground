package com.playground.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

object ComposeConfiguration {
    fun CommonExtension<*, *, *, *>.configureCompose(project: Project) {
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose").get().toString()
        }
    }
}
