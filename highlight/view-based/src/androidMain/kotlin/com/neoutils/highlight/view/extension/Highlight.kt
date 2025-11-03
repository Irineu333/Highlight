package com.neoutils.highlight.view.extension

import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.merge
import com.neoutils.highlight.core.extension.plus
import com.neoutils.highlight.core.extension.range
import com.neoutils.xregex.extension.findAll

fun Highlight.applyTo(
    text: Spannable,
    range: IntRange = text.range
) {
    for (scheme in schemes) {

        val mergedRange = (scheme.range ?: text.range).merge(range)

        for (result in scheme.regex.findAll(text, mergedRange)) {

            val spans by lazy { scheme.toParcelableSpan() }

            for (group in result.groups) {

                if (group == null) continue
                val span = spans[group.index] ?: continue

                text.setSpan(
                    span,
                    group.range.first,
                    group.range.last + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
    }
}


fun Highlight.toSpannedString(
    text: String
): SpannedString {

    return SpannedString.valueOf(
        SpannableString(text).apply(::applyTo)
    )
}



