package com.raiden.lint.implementationsuffix

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import com.intellij.psi.PsiClass
import org.jetbrains.uast.UClass

class NamingPatternHandler(private val context: JavaContext) :
    UElementHandler() {
    private lateinit var node: UClass
    private lateinit var interfaces: Array<PsiClass>
    private lateinit var interfaceName: String;
    private lateinit var className: String

    override fun visitClass(node: UClass) {
        this.node = node
        interfaces = node.interfaces
        val isImplOfOneInterface = interfaces.size == 1
        if (isImplOfOneInterface) {
            checkImplementationClassName()
        }
    }

    private fun checkImplementationClassName() {
        className = node.name!!
        val firstInterface = interfaces.first()
        interfaceName = firstInterface.name!!
        val isContainedInterfaceName = className.contains(interfaceName)
        val isEndedWithImplPrefix = className.endsWith("Impl")
        if (isContainedInterfaceName && !isEndedWithImplPrefix) {
            reportMessage()
        }
    }

    private fun reportMessage() {
        context.report(
            ISSUE_IMPLEMENTATION_NAMING_PATTERN,
            node,
            context.getNameLocation(node),
            "ImplementationClass should contain suffix Impl",
            quickFix()
        )
    }

    private fun quickFix(): LintFix {
        val nameWithSuffix = interfaceName + "Impl"
        return LintFix.create()
            .replace()
            .text(className)
            .with(nameWithSuffix)
            .build()
    }

}