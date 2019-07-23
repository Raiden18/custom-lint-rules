package com.raiden.lint.parameters.count

import com.android.tools.lint.detector.api.*

val ISSUE_TOO_MANY_PARAMETERS_FOR_METHOD_PATTERN = Issue.create(
    "Too many parameters for method Pattern",
    "Maximum count of parameters for method is 2",
    "Method shouldn't contain more that two parameters",
    Category.CORRECTNESS,
    5,
    Severity.WARNING,
    Implementation(
        TooManyParametersForMethodPatternDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)