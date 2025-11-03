package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.xregex.XRegex

class BackgroundColorScope internal constructor() :
    SchemeScope<UiColor, BackgroundColorScheme>() {

    override fun addScheme(
        regex: XRegex,
        matcher: Matcher<UiColor>,
        range: IntRange?
    ) {
        builder.add(
            BackgroundColorScheme(
                regex = regex,
                matcher = matcher,
                range = range
            )
        )
    }
}