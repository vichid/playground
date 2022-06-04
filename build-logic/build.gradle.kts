plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "io.github.vichid"
version = "0.0.6"

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

dependencies {
    implementation(libs.agp)
    implementation(libs.anvil)
    implementation(libs.dependencyAnalysis)
    implementation(libs.doctor)
    implementation(libs.kotlin.gradle)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kover) {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jdk8")
    }
    implementation(libs.gradlePlugins.ktlint)
    implementation(libs.moduleGraphAssertion)
    implementation(libs.versionUpdate)
}
