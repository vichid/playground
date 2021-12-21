import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.accessors.dm.LibrariesForLibs

apply(plugin = "com.diffplug.spotless")

configure<SpotlessExtension> {
    val libs = the<LibrariesForLibs>()
    format("misc") {
        target("**/*.md", "**/.gitignore")
        targetExclude("**/.gradle/**")
        indentWithTabs()
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlin {
        target("**/src/**/*.kt", "**/src/**/*.kt")
        targetExclude("**/spotless/*.kt")
        ktlint(libs.versions.ktlint.get()).userData(mapOf("android" to "true"))
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint(libs.versions.ktlint.get())
        trimTrailingWhitespace()
        endWithNewline()
    }
    java {
        target("**/src/**/*.java")
        targetExclude("**/spotless/*.java")
        googleJavaFormat(libs.versions.googlejavaformat.get())
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
    }
    groovyGradle {
        target("**/*.gradle")
        trimTrailingWhitespace()
        endWithNewline()
    }
}
