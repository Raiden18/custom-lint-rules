package com.raiden.lint.onelevelabstraction

import com.android.tools.lint.detector.api.*

val ISSUE_ONE_LEVEL_ABSTRACTION_PATTERN = Issue.create(
    "FOR LOOP LEVEL ABSTRACTION",
    "One function for one level of abstraction",
    "Your branch should contain only one branch",
    Category.CORRECTNESS,
    5,
    Severity.WARNING,
    Implementation(
        OneLevelAbstractionPatternDetector::class.java,
        Scope.JAVA_FILE_SCOPE
    )
)