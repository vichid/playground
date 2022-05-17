package com.playground.buildlogic

import java.util.Locale

enum class ModuleConfiguration {
    API,
    IMPL,
    DEMO,
    FAKES;

    override fun toString(): String = name.toLowerCase(Locale.getDefault())
}

fun StringBuilder.appendConfiguration(moduleConfiguration: ModuleConfiguration): StringBuilder =
    when (moduleConfiguration) {
        ModuleConfiguration.API -> appendPluginLibrary()
        ModuleConfiguration.IMPL -> appendPluginLibrary()
            .appendLibraryDependency()
        ModuleConfiguration.DEMO -> appendApplication()
        ModuleConfiguration.FAKES -> appendPluginLibrary()
            .appendLibraryDependency()
    }

private fun StringBuilder.appendPluginLibrary(): StringBuilder = append(
    "plugins {\n" +
        "    id(\"com.playground.buildlogic.library\")\n" +
        "}\n"
)

private fun StringBuilder.appendApplication(): StringBuilder = append(
    "plugins {\n" +
        "    id(\"com.playground.buildlogic.application.compose\")\n" +
        "}\n" +
        "\n" +
        "android {\n" +
        "    defaultConfig {\n" +
        "        applicationId = \"com.example.playground.\$s\"\n" +
        "\n" +
        "        testInstrumentationRunner = \"androidx.test.runner.AndroidJUnitRunner\"\n" +
        "    }\n" +
        "}\n"
)

private fun StringBuilder.appendLibraryDependency(): StringBuilder = append(
    "\n" +
        "dependencies {\n" +
        "    api(projects.\$s.api)\n" +
        "}\n"
)
