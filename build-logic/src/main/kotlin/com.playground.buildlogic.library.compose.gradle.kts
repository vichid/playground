import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.playground.buildlogic.ComposeConfiguration.configureCompose

plugins {
    id("com.playground.buildlogic.library")
}

plugins.withType<LibraryPlugin> {
    extensions.getByType<LibraryExtension>().configureCompose(project)
}
