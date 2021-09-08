
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

gradlePlugin {
    plugins {
        create("CommonAndroidConfigurationPlugin") {
            id = "common.android.configuration"
            implementationClass = "com.playground.CommonAndroidConfigurationPlugin"
        }
        create("AppVersioningPlugin") {
            id = "app.versioning"
            implementationClass = "com.playground.AppVersioningPlugin"
        }
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradle)
    implementation(libs.gradlePlugins.android)
}
