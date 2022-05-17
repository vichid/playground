import com.android.build.gradle.AppPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.playground.buildlogic.ComposeConfiguration.configureCompose

plugins {
    id("com.playground.buildlogic.application")
}

plugins.withType<AppPlugin> {
    extensions.getByType<BaseAppModuleExtension>().configureCompose(project)
}
