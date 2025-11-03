package com.neoutils.highlight.compose.scheme

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.xRegex

class SpanStyleScheme(
    override val regex: XRegex,
    override val matcher: Matcher<SpanStyle>,
    override val range: IntRange?,
) : Scheme<SpanStyle> {

    constructor(
        regex: Regex,
        matcher: Matcher<SpanStyle>,
        range: IntRange? = null
    ) : this(
        regex = regex.xRegex(),
        matcher = matcher,
        range = range
    )
}