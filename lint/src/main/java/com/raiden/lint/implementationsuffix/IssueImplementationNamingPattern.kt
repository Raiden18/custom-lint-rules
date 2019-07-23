package com.raiden.lint.implementationsuffix

import com.android.tools.lint.detector.api.*

val ISSUE_IMPLEMENTATION_NAMING_PATTERN = Issue.create(
    "Naming Implementation Pattern",
    "Implementation class name should be well named.",
    "Implementation class  should contain suffix Impl",
    Category.CORRECTNESS,
    5,
    Severity.WARNING,
    Implementation(
        ImplementationNamingPatternDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)