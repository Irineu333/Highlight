package com.neoutils.highlight.view.scheme

import android.graphics.Typeface
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.view.util.UiStyle
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.xRegex

data class TextStyleScheme(
    override val regex: XRegex,
    override val matcher: Matcher<UiStyle>,
    override val range: IntRange? = null,
) : Scheme<UiStyle> {

    constructor(
        regex: Regex,
        matcher: Matcher<UiStyle>,
        range: IntRange? = null
    ) : this(
        regex = regex.xRegex(),
        matcher = matcher,
        range = range
    )
}