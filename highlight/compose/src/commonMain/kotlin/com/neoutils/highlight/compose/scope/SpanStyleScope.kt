package com.neoutils.highlight.compose.scope

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex

class SpanStyleScope internal constructor() :
    SchemeScope<SpanStyle, SpanStyleScheme>() {

    override fun addScheme(
        regex: XRegex,
        matcher: Matcher<SpanStyle>,
        range: IntRange?
    ) {
        builder.add(
            SpanStyleScheme(
                regex = regex,
                matcher = matcher,
                range = range
            )
        )
    }
}
