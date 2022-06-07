plugins {
    id("io.github.vichid.jvm")
    kotlin("kapt")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs =
            freeCompilerArgs + listOf("-opt-in=com.squareup.anvil.annotations.ExperimentalAnvilApi")
    }
}

dependencies {
    implementation(projects.androidApp.coreDi.api)

    api(libs.kotlinCompilerEmbeddable)
    api(libs.anvil.compiler.api)
    implementation(libs.anvil.annotations)
    implementation(libs.anvil.compiler.utils)
    implementation(libs.kotlinPoet)
    implementation(libs.dagger)
    implementation(libs.retrofit)

    compileOnly(libs.autoService.annotations)
    kapt(libs.autoService)
}
