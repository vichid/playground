package io.github.vichid

import com.example.core.di.ContributesViewModel
import com.google.auto.service.AutoService
import com.squareup.anvil.annotations.ContributesMultibinding
import com.squareup.anvil.compiler.api.AnvilContext
import com.squareup.anvil.compiler.api.CodeGenerator
import com.squareup.anvil.compiler.api.GeneratedFile
import com.squareup.anvil.compiler.api.createGeneratedFile
import com.squareup.anvil.compiler.internal.asClassName
import com.squareup.anvil.compiler.internal.buildFile
import com.squareup.anvil.compiler.internal.fqName
import com.squareup.anvil.compiler.internal.reference.ClassReference
import com.squareup.anvil.compiler.internal.reference.asClassName
import com.squareup.anvil.compiler.internal.reference.classAndInnerClassReferences
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtFile
import java.io.File
import javax.inject.Inject

@AutoService(CodeGenerator::class)
class ContributesViewModelCodeGenerator : CodeGenerator {
    private val viewModelFactoryFqName = FqName("com.example.core.di.utils.ViewModelFactory")

    override fun isApplicable(context: AnvilContext): Boolean = true

    override fun generateCode(
        codeGenDir: File,
        module: ModuleDescriptor,
        projectFiles: Collection<KtFile>
    ): Collection<GeneratedFile> {
        return projectFiles.classAndInnerClassReferences(module)
            .toList()
            .filter { it.isAnnotatedWith(ContributesViewModel::class.fqName) }
            .flatMap { listOf(generateFactory(it, codeGenDir, module)) }
            .toList()
    }

    private fun generateFactory(
        vmClass: ClassReference.Psi,
        codeGenDir: File,
        module: ModuleDescriptor
    ): GeneratedFile {
        val generatedPackage = vmClass.packageFqName.toString()
        val factoryClassName = "${vmClass.shortName}_ViewModelFactory"
        val scope = vmClass.annotations.first { it.fqName == ContributesViewModel::class.fqName }
            .scopeOrNull(0)
        val constructor =
            vmClass.constructors.singleOrNull { it.isAnnotatedWith(Inject::class.fqName) }
        val defaultParameterValues =
            constructor?.parameters?.any { it.parameter.hasDefaultValue() } ?: false
        if (constructor == null) {
            throw anvilException(vmClass, "must have an @Inject constructor")
        }
        if (defaultParameterValues) {
            throw anvilException(vmClass, "constructor parameters must not have default values")
        }
        val content = FileSpec.buildFile(generatedPackage, factoryClassName) {
            addType(
                TypeSpec.classBuilder(factoryClassName)
                    .addSuperinterface(viewModelFactoryFqName.asClassName(module))
                    .addAnnotation(
                        AnnotationSpec.builder(ContributesMultibinding::class)
                            .addMember("%T::class", scope!!.asClassName())
                            .build()
                    )
                    .primaryConstructor(viewModelConstructor(vmClass))
                    .addFunction(
                        FunSpec.builder("create")
                            .addAnnotation(viewModelAnnotation())
                            .addModifiers(KModifier.OVERRIDE)
                            .addTypeVariable(viewModelTypeVariable())
                            .addParameter(viewModelParameter())
                            .returns(TypeVariableName("T").copy(nullable = true))
                            .addCode(viewModelProviderCode(), vmClass.asClassName())
                            .build()
                    )
                    .build()
            ).build()
        }

        return createGeneratedFile(codeGenDir, generatedPackage, factoryClassName, content)
    }

    private fun viewModelAnnotation() = AnnotationSpec.builder(Suppress::class)
        .addMember("\"UNCHECKED_CAST\"")
        .build()

    private fun viewModelTypeVariable() = TypeVariableName(
        "T",
        ClassName(
            "androidx.lifecycle",
            "ViewModel"
        ).copy(nullable = true)
    )

    private fun viewModelParameter() = ParameterSpec.builder(
        "modelClass",
        ClassName(
            "java.lang",
            "Class"
        ).parameterizedBy(TypeVariableName("T"))
    ).build()

    private fun viewModelConstructor(vmClass: ClassReference.Psi) =
        PropertySpec.builder(
            "viewModelProvider",
            ClassName(
                "javax.inject",
                "Provider"
            ).parameterizedBy(vmClass.asClassName())
        )
            .addModifiers(KModifier.PRIVATE)
            .build()

    private fun viewModelProviderCode() =
        """
            with(modelClass) {
                return when {
                    isAssignableFrom(%T::class.java) -> (viewModelProvider.get() as T)
                    else -> null
                }
            }
        """.trimIndent()

    private fun TypeSpec.Builder.primaryConstructor(vararg properties: PropertySpec): TypeSpec.Builder {
        val propertySpecs = properties.map { p -> p.toBuilder().initializer(p.name).build() }
        val parameters = propertySpecs.map { ParameterSpec.builder(it.name, it.type).build() }
        val constructor = FunSpec.constructorBuilder()
            .addParameters(parameters)
            .addAnnotation(AnnotationSpec.builder(Inject::class).build())
            .build()

        return this
            .primaryConstructor(constructor)
            .addProperties(propertySpecs)
    }
}
