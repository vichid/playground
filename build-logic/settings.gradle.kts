rootProject.name = "build-logic"

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

if ("detekt.rules.path" in extra.properties) {
    val path = (extra["detekt.rules.path"] as String)
    includeBuild(path) {
        dependencySubstitution {
            substitute(module("io.github.vichid:detekt-rules"))
                .using(project(":"))
        }
    }
}

