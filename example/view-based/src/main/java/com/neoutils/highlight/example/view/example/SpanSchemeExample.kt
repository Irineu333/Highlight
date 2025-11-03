package com.neoutils.highlight.example.view.example

import android.content.Context
import android.graphics.Color
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.view.extension.span
import com.neoutils.highlight.view.extension.toSpannedString

class SpanSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    context,
    attr
) {
    init {
        text = Highlight {
            span {
                "\\bspan\\b"
                    .toRegex()
                    .fully(
                        ForegroundColorSpan(
                            Color.GREEN
                        )
                    )
            }
        }.toSpannedString(
            "Example of span"
        )
    }
}