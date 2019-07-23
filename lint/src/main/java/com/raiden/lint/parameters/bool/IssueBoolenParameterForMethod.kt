package com.raiden.lint.parameters.bool

import com.android.tools.lint.detector.api.*

val ISSUE_BOOLEAN_PARAMETER_FOR_METHOD_PATTERN = Issue.create(
    "Boolean parameter for method",
    "Boolean for method parameter is not good idea",
    "Boolean for method parameter is not good idea. Probably method does two things." +
            "Method must do only one thing and do it every well",
    Category.CORRECTNESS,
    5,
    Severity.WARNING,
    Implementation(
        BooleanParameterForMethodPatternDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)