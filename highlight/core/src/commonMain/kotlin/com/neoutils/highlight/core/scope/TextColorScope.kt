package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.xregex.XRegex

class TextColorScope internal constructor() : SchemeScope<UiColor, TextColorScheme>() {

    override fun addScheme(
        regex: XRegex,
        matcher: Matcher<UiColor>,
        range: IntRange?
    ) {
        builder.add(
            TextColorScheme(
                regex = regex,
                matcher = matcher,
                range = range
            )
        )
    }
}