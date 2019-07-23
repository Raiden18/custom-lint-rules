package com.raiden.lint.onelevelabstraction

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.JavaContext
import com.raiden.lint.parameters.bool.ISSUE_BOOLEAN_PARAMETER_FOR_METHOD_PATTERN
import org.jetbrains.uast.UBlockExpression
import org.jetbrains.uast.UMethod

class OneLevelAbstractionPatternHandler(private val context: JavaContext) : UElementHandler() {
    private lateinit var blockNode: UBlockExpression

    override fun visitBlockExpression(node: UBlockExpression) {
        this.blockNode = node
        if (node.expressions.size > 1 && isOneMethodAbstraction()) {
            reportMessage()
        }
    }

    private fun isOneMethodAbstraction(): Boolean {
        return blockNode.uastParent !is UMethod
    }

    private fun reportMessage() {
        context.report(
            ISSUE_BOOLEAN_PARAMETER_FOR_METHOD_PATTERN,
            blockNode,
            context.getNameLocation(blockNode),
            "One method for one level of abstraction. Your block shouldn't contain more that one method."
        )
    }

}