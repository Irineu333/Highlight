package com.neoutils.highlight.core.extension

import com.neoutils.highlight.core.scope.BackgroundColorScope
import com.neoutils.highlight.core.scope.HighlightScope
import com.neoutils.highlight.core.scope.TextColorScope

fun HighlightScope.textColor(scope: TextColorScope.() -> Unit) {
    addSchemes(TextColorScope().apply(scope).schemes)
}

fun HighlightScope.backgroundColor(scope: BackgroundColorScope.() -> Unit) {
    addSchemes(BackgroundColorScope().apply(scope).schemes)
}

