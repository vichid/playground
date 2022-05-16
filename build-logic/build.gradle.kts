plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "io.github.vichid"
version = "0.0.6"

val targetJavaVersion = JavaVersion.VERSION_11
tasks.withType<JavaCompile>().configureEach {
    options.release.set(targetJavaVersion.majorVersion.toInt())
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        allWarningsAsErrors = true
    }
}

dependencies {
    implementation(libs.android)
    implementation(libs.dependency)
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
