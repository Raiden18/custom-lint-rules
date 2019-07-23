package com.raiden.lint.parameters.bool

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.JavaContext
import com.intellij.psi.util.PsiTypesUtil
import org.jetbrains.uast.*

class BooleanParameterForMethodPatternHandler(private val context: JavaContext) : UElementHandler() {
    private lateinit var node: UMethod

    override fun visitMethod(node: UMethod) {
        this.node = node
        val isAbstractMethod = context.evaluator.isAbstract(node)
        if (isAbstractMethod) {
            checkBooleanParameters()
        }
    }

    private fun checkBooleanParameters() {
        node.uastParameters.forEach {
            checkBooleanParameter(it)
        }
    }

    private fun checkBooleanParameter(parameter: UParameter) {
        val current = PsiTypesUtil.getDefaultValue(parameter.type)
        val isBoolean = current is Boolean
        if (isBoolean) {
            reportMessage()
        }
    }

    private fun reportMessage() {
        context.report(
            ISSUE_BOOLEAN_PARAMETER_FOR_METHOD_PATTERN,
            node,
            context.getNameLocation(node),
            "Boolean for method parameter is not good idea. Please, divide this method into two methods."
        )
    }
}