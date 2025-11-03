package com.neoutils.highlight.core

import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex

interface Scheme<T : Any> {
    val regex: XRegex
    val matcher: Matcher<T>
    val range: IntRange?
}
