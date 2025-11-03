package com.neoutils.highlight.view.scope

import android.text.ParcelableSpan
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.view.scheme.SpanScheme
import com.neoutils.xregex.XRegex

class SpanScope internal constructor() :
    SchemeScope<ParcelableSpan, SpanScheme>() {

    override fun addScheme(
        regex: XRegex,
        matcher: Matcher<ParcelableSpan>,
        range: IntRange?
    ) {
        builder.add(
            SpanScheme(
                regex = regex,
                matcher = matcher,
                range = range
            )
        )
    }
}