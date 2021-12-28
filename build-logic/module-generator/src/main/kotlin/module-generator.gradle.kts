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
        val moduleName = moduleInput ?: return
        val configurationList = configurationInput ?: return

        with(project) {
            generateDirs(moduleName, configurationList)
            generateManifest(moduleName, configurationList)
            generateBuildGradle(moduleName, configurationList)
            generateModuleSettings(moduleName, configurationList)
        }
    }

    private fun Project.generateDirs(moduleName: String, configurationList: List<Configuration>) {
        configurationList.forEach {
            mkdir("$moduleName/${it.name.toLowerCase()}/src/main/kotlin/")
            if (it == Configuration.IMPL) {
                mkdir("$moduleName/${it.name.toLowerCase()}/src/androidTest/kotlin/")
                mkdir("$moduleName/${it.name.toLowerCase()}/src/test/kotlin/")
            }
        }
    }

    private fun Project.generateBuildGradle(
        moduleName: String,
        configurationList: List<Configuration>
    ) {
        val temp = "-[a-zA-Z]".toRegex().replace(moduleName) {
            it.value.replace("-", "")
                .toUpperCase()
        }
        configurationList
            .map { configuration ->
                configuration to file("${projectDir}/build-logic/module-generator/src/main/templates/${configuration.name.toLowerCase()}.gradle.kts")
                    .readText()
                    .replace("\$s", temp)
            }
            .forEach { pair ->
                file("$moduleName/${pair.first.name.toLowerCase()}/build.gradle.kts")
                    .writeText(pair.second)
            }
    }

    private fun Project.generateManifest(
        moduleName: String,
        configurationList: List<Configuration>
    ) {
        configurationList.forEach {
            file("$moduleName/${it.name.toLowerCase()}/src/main/AndroidManifest.xml")
                .writeText("<manifest package=\"$packageName.$moduleName.${it.name.toLowerCase()}\" />\n")
        }
    }

    private fun Project.generateModuleSettings(
        moduleName: String,
        configurationList: List<Configuration>
    ) {
        val modulesFile = "modules.gradle.kts"
        val originalModules = file(modulesFile).readLines().toMutableList()
        configurationList
            .forEach {
                val include = "include(\":$moduleName:${it.name.toLowerCase()}\")"
                if (!originalModules.contains(include)) {
                    originalModules.add(include)
                }
            }

        originalModules.sort()
        file(modulesFile).writeText(originalModules.joinToString(separator = "\n", postfix = "\n"))
    }

    enum class Configuration {
        API, IMPL, DEMO, FAKES
    }

    companion object {
        const val packageName = "com.example"
    }
}

tasks.register<ModuleGenerationTask>("createModules") {
    group = "help"
    description = "Creates a new set of modules following project structure"
}
