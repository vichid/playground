open class ModuleGenerationTask : DefaultTask() {

    private var moduleInput: String? = null
    private var configurationInput: List<Configuration>? = null

    @Option(option = "module", description = "")
    open fun setModule(moduleInput: String?) {
        this.moduleInput = moduleInput
    }

    @Option(option = "configurations", description = "")
    open fun setConfiguration(configurationInput: List<Configuration>?) {
        this.configurationInput = configurationInput
    }

    @Input
    open fun getModule(): String? = moduleInput

    @Input
    open fun getConfigurations(): List<Configuration>? = configurationInput

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

    private fun String.cleanModuleName(): String = "[^-a-z]".toRegex().replace(toLowerCase(), "")

    private fun Project.generateDirs(moduleName: String, configurationList: List<Configuration>) {
        configurationList.forEach { configuration ->
            val configurationPath = "$packageName.$moduleName.$configuration"
                .replace('.', '/')
                .replace("-", "")
            mkdir("$moduleName/$configuration/src/main/kotlin/$configurationPath")
            if (configuration == Configuration.IMPL) {
                mkdir("$moduleName/$configuration/src/androidTest/kotlin/$configurationPath")
                mkdir("$moduleName/$configuration/src/test/kotlin/$configurationPath")
            }
        }
    }

    private fun Project.generateManifest(
        moduleName: String,
        configurationList: List<Configuration>
    ) {
        configurationList.forEach { configuration ->
            file("$moduleName/$configuration/src/main/AndroidManifest.xml")
                .writeText(
                    "<manifest package=\"$packageName.${
                        moduleName.replace(
                            "-",
                            ""
                        )
                    }.$configuration\" />\n"
                )
        }
    }

    private fun Project.generateBuildGradle(
        moduleName: String,
        configurationList: List<Configuration>
    ) {
        val camelCaseModuleName = "-[a-zA-Z]".toRegex().replace(moduleName) {
            it.value.replace("-", "")
                .toUpperCase()
        }
        configurationList
            .map { configuration ->
                configuration to file("${projectDir}/build-logic/module-generator/src/main/templates/$configuration.gradle.kts")
                    .readText()
                    .replace("\$s", camelCaseModuleName)
            }
            .forEach { pair ->
                file("$moduleName/${pair.first.name}/build.gradle.kts")
                    .writeText(pair.second)
            }
    }

    private fun Project.generateModuleSettings(
        moduleName: String,
        configurationList: List<Configuration>
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

    enum class Configuration {
        API, IMPL, DEMO, FAKES;

        override fun toString(): String = name.toLowerCase()
    }

    companion object {
        const val packageName = "com.example"
    }
}

tasks.register<ModuleGenerationTask>("createModules") {
    group = "help"
    description = "Creates a new set of modules following project structure"
}
