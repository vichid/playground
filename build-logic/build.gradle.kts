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
    implementation(libs.ktlint)
    implementation(libs.moduleGraphAssertion)
    implementation(libs.versionUpdate)
}
