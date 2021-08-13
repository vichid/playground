buildscript {
    dependencies {
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs") as org.gradle.accessors.dm.LibrariesForLibs
        classpath(libs.gradlePlugins.android)
        classpath(libs.gradlePlugins.kotlin)
    }

    repositories {
        google()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

allprojects {
    buildscript {
        repositories {
            google()
            maven {
                url = uri("https://plugins.gradle.org/m2/")
            }
        }
    }

    repositories {
        google()
        mavenCentral()
    }
}
