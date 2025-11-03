package com.neoutils.highlight.core.extension

import kotlin.math.max
import kotlin.math.min

infix operator fun IntRange.plus(range: IntRange): IntRange {
    return IntRange(
        start = start + range.first,
        endInclusive = endInclusive + range.first
    )
}

fun IntRange.merge(other: IntRange): IntRange {
    return IntRange(
        start = max(first, other.first),
        endInclusive = min(last, other.last)
    )
}