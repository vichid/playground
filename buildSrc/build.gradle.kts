
plugins {
    `kotlin-dsl`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.kotlin.stdlib)
}
