package com.raiden.lint.interfaceprefix


import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import org.jetbrains.uast.UClass

val ISSUE_INTERFACE_NAMING_PATTERN = Issue.create(
    "Naming Interface Pattern",
    "Interface name should be well named.",
    "Interface shouldn't contain prefix and suffix because it is API. Client classes don't need " +
            "any additional information.",
    CORRECTNESS,
    5,
    Severity.WARNING,
    Implementation(
        InterfaceNamingPatternDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)

class InterfaceNamingPatternDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(UClass::class.java)
    override fun createUastHandler(context: JavaContext) = NamingPatternHandler(context)

    class NamingPatternHandler(private val context: JavaContext) :
        UElementHandler() {
        override fun visitClass(node: UClass) {
            if (node.isInterface && node.name?.isCorrectInterfaceName() == false) {
                context.report(
                    ISSUE_INTERFACE_NAMING_PATTERN, node,
                    context.getNameLocation(node),
                    "Interface shouldn't contain prefix",
                    quickFix(node.name!!)
                )
            }
        }

        private fun quickFix(displayData: String): LintFix {
            val nameWithoutPrefix = displayData.replaceFirst("I", "")
            return LintFix.create()
                .replace()
                .text(displayData)
                .with(nameWithoutPrefix)
                .build()
        }
    }
}

internal fun String.isCorrectInterfaceName(): Boolean {
    return !(this.startsWith("I") && this[1].isUpperCase())
}
