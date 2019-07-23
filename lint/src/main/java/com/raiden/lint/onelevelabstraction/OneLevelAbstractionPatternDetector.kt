package com.raiden.lint.onelevelabstraction

import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UBlockExpression

class OneLevelAbstractionPatternDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(UBlockExpression::class.java)

    override fun createUastHandler(context: JavaContext) =
        OneLevelAbstractionPatternHandler(context)
}