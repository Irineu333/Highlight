package com.neoutils.highlight.view.scope

import android.graphics.Typeface
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.view.scheme.TextFontScheme
import com.neoutils.xregex.XRegex

class TextFontScope internal constructor() :
    SchemeScope<Typeface, TextFontScheme>() {

    override fun addScheme(
        regex: XRegex,
        matcher: Matcher<Typeface>,
        range: IntRange?
    ) {
        builder.add(
            TextFontScheme(
                regex = regex,
                matcher = matcher,
                range = range
            )
        )
    }
}