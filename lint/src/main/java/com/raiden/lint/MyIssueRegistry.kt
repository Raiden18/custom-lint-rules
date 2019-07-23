package com.raiden.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue
import com.raiden.lint.implementationsuffix.ISSUE_IMPLEMENTATION_NAMING_PATTERN
import com.raiden.lint.interfaceprefix.ISSUE_INTERFACE_NAMING_PATTERN
import com.raiden.lint.onelevelabstraction.ISSUE_ONE_LEVEL_ABSTRACTION_PATTERN
import com.raiden.lint.parameters.bool.ISSUE_BOOLEAN_PARAMETER_FOR_METHOD_PATTERN
import com.raiden.lint.parameters.count.ISSUE_TOO_MANY_PARAMETERS_FOR_METHOD_PATTERN

class MyIssueRegistry : IssueRegistry() {
    override val issues: List<Issue> = listOf(
        ISSUE_INTERFACE_NAMING_PATTERN,
        ISSUE_IMPLEMENTATION_NAMING_PATTERN,
        ISSUE_TOO_MANY_PARAMETERS_FOR_METHOD_PATTERN,
        ISSUE_BOOLEAN_PARAMETER_FOR_METHOD_PATTERN,
        ISSUE_ONE_LEVEL_ABSTRACTION_PATTERN
    )
}
