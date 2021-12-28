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

        generateDirs(moduleName, configurationList)
        generateManifest(moduleName, configurationList)
        generateBuildGradle(moduleName, configurationList)
        generateModuleSettings(moduleName, configurationList)
    }

    private fun generateDirs(moduleName: String, configurationList: List<Configuration>) {
        configurationList.forEach {
            project.mkdir("$moduleName/${it.name.toLowerCase()}/src/main/kotlin/")
            if (it == Configuration.IMPL) {
                project.mkdir("$moduleName/${it.name.toLowerCase()}/src/androidTest/kotlin/")
                project.mkdir("$moduleName/${it.name.toLowerCase()}/src/test/kotlin/")
            }
        }
    }

    private fun generateBuildGradle(moduleName: String, configurationList: List<Configuration>) {
        configurationList
            .map { configuration ->
                configuration to project.file("${project.projectDir}/build-logic/module-generator/src/main/templates/${configuration.name.toLowerCase()}.gradle.kts")
                    .readText()
            }
            .forEach { pair ->
                project.file("$moduleName/${pair.first.name.toLowerCase()}/build.gradle.kts")
                    .writeText(pair.second)
            }
    }

    private fun generateManifest(moduleName: String, configurationList: List<Configuration>) {
        configurationList.forEach {
            project.file("$moduleName/${it.name.toLowerCase()}/src/main/AndroidManifest.xml")
                .writeText("<manifest package=\"$packageName.$moduleName.${it.name.toLowerCase()}\" />\n")
        }
    }

    private fun generateModuleSettings(moduleName: String, configurationList: List<Configuration>) {
        val modulesFile = "modules.gradle.kts"
        val originalModules = project.file(modulesFile).readLines().toMutableList()
        configurationList
            .forEach {
                val include = "include(\":$moduleName:${it.name.toLowerCase()}\")"
                if (!originalModules.contains(include)) {
                    originalModules.add(include)
                }
            }

        originalModules.sort()
        project.file(modulesFile).writeText(originalModules.joinToString(separator = "\n"))
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
