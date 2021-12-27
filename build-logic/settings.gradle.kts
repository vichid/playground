rootProject.name = "build-logic"

enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

include("convention-versioning")
include("convention-android")
include("convention-analyzers")
include("convention-monitoring")
include("module-generator")
