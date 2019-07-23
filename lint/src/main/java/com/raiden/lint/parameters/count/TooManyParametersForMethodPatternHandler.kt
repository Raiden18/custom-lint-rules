package com.raiden.lint.parameters.count

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UMethod

class TooManyParametersForMethodPatternHandler(private val context: JavaContext) :
    UElementHandler() {
    private companion object {
        const val MAX_COUNT_OF_PARAMETERS = 2
    }

    private lateinit var node: UMethod

    override fun visitMethod(node: UMethod) {
        this.node = node
        if (node.isConstructor.not()) {
            checkParameters()
        }
    }

    private fun checkParameters() {
        val parametersCount = node.parameters.size
        val isExceededMaxCountParameters = parametersCount > MAX_COUNT_OF_PARAMETERS
        if (isExceededMaxCountParameters) {
            reportMessage()
        }
    }

    private fun reportMessage() {
        context.report(
            ISSUE_TOO_MANY_PARAMETERS_FOR_METHOD_PATTERN,
            node,
            context.getNameLocation(node),
            "Max count of parameters for method is 2"
        )
    }
}