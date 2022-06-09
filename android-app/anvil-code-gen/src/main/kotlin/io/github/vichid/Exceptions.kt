package io.github.vichid

import com.squareup.anvil.compiler.api.AnvilCompilationException
import com.squareup.anvil.compiler.internal.reference.ClassReference

fun anvilException(vmClass: ClassReference.Psi, message: String) = AnvilCompilationException(
    "${vmClass.fqName} $message",
    element = vmClass.clazz.identifyingElement,
)
