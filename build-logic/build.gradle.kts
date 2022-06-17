plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "io.github.vichid"
version = "0.0.17"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/vichid/playground")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

gradlePlugin {
    plugins {
        register("root") {
            id = "io.github.vichid.root"
            implementationClass = "AndroidProjectConventionPlugin"
        }
        register("application") {
            id = "io.github.vichid.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("applicationCompose") {
            id = "io.github.vichid.application.compose"
            implementationClass = "ApplicationComposeConventionPlugin"
        }
        register("library") {
            id = "io.github.vichid.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("libraryCompose") {
            id = "io.github.vichid.library.compose"
            implementationClass = "LibraryComposeConventionPlugin"
        }
        register("jvm") {
            id = "io.github.vichid.jvm"
            implementationClass = "JvmConventionPlugin"
        }
        register("test") {
            id = "io.github.vichid.test"
            implementationClass = "TestConventionPlugin"
        }
        register("kotlin") {
            id = "io.github.vichid.kotlin"
            implementationClass = "KotlinConventionPlugin"
        }
        register("module") {
            id = "io.github.vichid.module"
            implementationClass = "ModuleConventionPlugin"
        }
    }
}

dependencies {
    implementation(libs.detekt.api)
    implementation(libs.gradlePlugins.android)
    implementation(libs.gradlePlugins.anvil)
    implementation(libs.gradlePlugins.autoManifest)
    implementation(libs.gradlePlugins.dependencyAnalysis)
    implementation(libs.gradlePlugins.detekt)
    implementation(libs.gradlePlugins.doctor)
    implementation(libs.gradlePlugins.kotlin)
    implementation(libs.gradlePlugins.moduleGraphAssertion)
    implementation(libs.gradlePlugins.paparazzi)
    implementation(libs.gradlePlugins.ruler)
    implementation(libs.gradlePlugins.versionUpdate)
    implementation(libs.kover) { exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jdk8") }
}
