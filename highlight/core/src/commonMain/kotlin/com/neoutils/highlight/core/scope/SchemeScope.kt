package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.Scope
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.xRegex

abstract class SchemeScope<T : Any, S : Scheme<*>> : Scope<S>() {

    protected abstract fun addScheme(
        regex: XRegex,
        matcher: Matcher<T>,
        range: IntRange? = null
    )

    private fun addScheme(
        regex: Regex,
        matcher: Matcher<T>,
        range: IntRange? = null
    ) = addScheme(
        regex = regex.xRegex(),
        matcher = matcher,
        range = range
    )

    fun XRegex.match(
        range: IntRange? = null,
        scope: MutableMap<Int, T>.() -> Unit
    ) = addScheme(
        regex = this,
        matcher = Matcher(
            matches = buildMap(scope)
        ),
        range = range
    )

    fun Regex.match(
        range: IntRange? = null,
        scope: MutableMap<Int, T>.() -> Unit
    ) = addScheme(
        regex = this,
        matcher = Matcher(
            matches = buildMap(scope)
        ),
        range = range
    )

    fun XRegex.match(
        vararg matches: Pair<Int, T>,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.all(*matches),
        range = range
    )

    fun Regex.match(
        vararg matches: Pair<Int, T>,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.all(*matches),
        range = range
    )

    fun XRegex.fully(
        value: T,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.fully(value),
        range = range
    )

    fun Regex.fully(
        value: T,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.fully(value),
        range = range
    )

    fun XRegex.groups(
        vararg groups: T,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.groups(*groups),
        range = range
    )

    fun Regex.groups(
        vararg groups: T,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.groups(*groups),
        range = range
    )
}