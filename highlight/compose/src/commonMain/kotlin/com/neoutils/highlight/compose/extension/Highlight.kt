package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.merge
import com.neoutils.highlight.core.extension.range
import com.neoutils.xregex.extension.findAll

fun Highlight.toAnnotatedString(
    text: String,
    range: IntRange = text.range
): AnnotatedString {

    val ranges = mutableListOf<AnnotatedString.Range<SpanStyle>>()

    for (scheme in schemes) {

        val spans by lazy { scheme.toSpanStyle() }

        val mergedRange = (scheme.range ?: text.range).merge(range)

        for (result in scheme.regex.findAll(text, mergedRange)) {

            for (group in result.groups) {

                if (group == null) continue
                val span = spans[group.index] ?: continue

                ranges.addOrMerge(
                    AnnotatedString.Range(
                        item = span,
                        start = group.range.first,
                        end = group.range.last + 1,
                    )
                )
            }
        }
    }

    return AnnotatedString(
        text = text,
        spanStyles = ranges
    )
}

fun MutableList<AnnotatedString.Range<SpanStyle>>.addOrMerge(
    spanStyle: AnnotatedString.Range<SpanStyle>
) {

    val collisions = filter {
        it.start < spanStyle.end && spanStyle.start < it.end
    }

    if (collisions.isEmpty()) {
        add(spanStyle)
        return
    }

    removeAll(collisions)

    addAll(
        collisions.flatMap {
            buildList {
                if (it.start < spanStyle.start) {
                    add(it.copy(end = spanStyle.start))
                }

                add(
                    it.copy(
                        item = it.item.merge(spanStyle.item),
                        start = maxOf(it.start, spanStyle.start),
                        end = minOf(it.end, spanStyle.end)
                    )
                )

                if (it.end > spanStyle.end) {
                    add(it.copy(start = spanStyle.end))
                }
            }
        }
    )

    add(spanStyle)
}
