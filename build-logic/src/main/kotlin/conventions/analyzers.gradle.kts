package conventions

import com.osacky.doctor.DoctorExtension

project.allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

apply(plugin = "com.osacky.doctor")
apply(plugin = "com.autonomousapps.dependency-analysis")
apply(plugin = "org.jetbrains.kotlinx.kover")

extensions.configure(DoctorExtension::class) {
    javaHome {
        ensureJavaHomeIsSet.set(false)
        ensureJavaHomeMatches.set(false)
    }
}
