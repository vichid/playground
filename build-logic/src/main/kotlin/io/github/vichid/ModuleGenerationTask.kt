package io.github.vichid

import io.github.vichid.ModuleConfiguration.IMPL
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

open class ModuleGenerationTask : DefaultTask() {

    private var moduleInput: String? = null
    private var configurationInput: List<ModuleConfiguration>? = null

    @Option(option = "module", description = "")
    open fun setModule(moduleInput: String?) {
        this.moduleInput = moduleInput
    }

    @Option(option = "configurations", description = "")
    open fun setConfiguration(configurationInput: List<ModuleConfiguration>?) {
        this.configurationInput = configurationInput
    }

    @Input
    open fun getModule(): String? = moduleInput

    @Input
    open fun getConfigurations(): List<ModuleConfiguration>? = configurationInput

    @TaskAction
    fun generate() {
        val moduleName = moduleInput?.cleanModuleName() ?: return
        val configurationList = configurationInput ?: return
        with(project) {
            generateDirs(moduleName, configurationList)
            generateManifest(moduleName, configurationList)
            generateBuildGradle(moduleName, configurationList)
            generateModuleSettings(moduleName, configurationList)
        }
    }

    private fun String.cleanModuleName(): String =
        "[^-a-z]".toRegex().replace(toLowerCase(), "")

    private fun Project.generateDirs(
        moduleName: String,
        configurationList: List<ModuleConfiguration>
    ) {
        configurationList.forEach { configuration ->
            val configurationPath = "$packageName.$moduleName.$configuration"
                .replace('.', '/')
                .replace("-", "")
            mkdir("$moduleName/$configuration/src/main/kotlin/$configurationPath")
            if (configuration == IMPL) {
                mkdir("$moduleName/$configuration/src/androidTest/kotlin/$configurationPath")
                mkdir("$moduleName/$configuration/src/test/kotlin/$configurationPath")
            }
        }
    }

    private fun Project.generateManifest(
        moduleName: String,
        configurationList: List<ModuleConfiguration>
    ) {
        val manifest = "<manifest package=\"$packageName.${moduleName.replace("-", "")}"
        configurationList.forEach { configuration ->
            file("$moduleName/$configuration/src/main/AndroidManifest.xml")
                .writeText(
                    "$manifest.$configuration\" />\n"
                )
        }
    }

    private fun Project.generateBuildGradle(
        moduleName: String,
        configurationList: List<ModuleConfiguration>
    ) {
        val camelCaseModuleName = "-[a-zA-Z]".toRegex().replace(moduleName) {
            it.value.replace("-", "")
                .toUpperCase()
        }
        configurationList
            .map { configuration ->
                val stringBuilder = StringBuilder()
                println(configuration)
                stringBuilder.appendConfiguration(configuration)
                println(stringBuilder.toString())
                configuration to stringBuilder.toString()
                    .replace("\$s", camelCaseModuleName)
            }
            .forEach { pair ->
                file("$moduleName/${pair.first}/build.gradle.kts")
                    .writeText(pair.second)
            }
    }

    private fun Project.generateModuleSettings(
        moduleName: String,
        configurationList: List<ModuleConfiguration>
    ) {
        val modulesFile = "modules.gradle.kts"
        val originalModules = file(modulesFile).readLines().toMutableList()
        configurationList
            .forEach { configuration ->
                val include = "include(\":$moduleName:$configuration\")"
                if (!originalModules.contains(include)) {
                    originalModules.add(include)
                }
            }

        originalModules.sort()
        file(modulesFile).writeText(originalModules.joinToString(separator = "\n", postfix = "\n"))
    }

    companion object {
        const val packageName = "com.example"
    }
}
