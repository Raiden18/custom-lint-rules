package com.raiden.lint.parameters.count

import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UMethod

class TooManyParametersForMethodPatternDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(UMethod::class.java)

    override fun createUastHandler(context: JavaContext) =
        TooManyParametersForMethodPatternHandler(context)
}