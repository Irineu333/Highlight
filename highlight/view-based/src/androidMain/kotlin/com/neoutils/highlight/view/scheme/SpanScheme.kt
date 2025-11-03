package com.neoutils.highlight.view.scheme

import android.text.ParcelableSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.xRegex

data class SpanScheme(
    override val regex: XRegex,
    override val matcher: Matcher<ParcelableSpan>,
    override val range: IntRange? = null,
) : Scheme<ParcelableSpan> {

    constructor(
        regex: Regex,
        matcher: Matcher<ParcelableSpan>,
        range: IntRange? = null
    ) : this(
        regex = regex.xRegex(),
        matcher = matcher,
        range = range
    )
}