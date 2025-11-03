package com.neoutils.highlight.view.scheme

import android.graphics.Typeface
import android.text.ParcelableSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.xRegex

data class TextFontScheme(
    override val regex: XRegex,
    override val matcher: Matcher<Typeface>,
    override val range: IntRange? = null,
) : Scheme<Typeface> {

    constructor(
        regex: Regex,
        matcher: Matcher<Typeface>,
        range: IntRange? = null
    ) : this(
        regex = regex.xRegex(),
        matcher = matcher,
        range = range
    )
}