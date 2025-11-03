package com.neoutils.highlight.view.text

import android.text.Editable
import android.text.TextWatcher
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.highlight.view.extension.applyTo
import com.neoutils.highlight.view.extension.getFirstLineStart
import com.neoutils.highlight.view.extension.getLastLineEnd
import com.neoutils.highlight.view.extension.removeSpans
import kotlin.random.Random

class LinesHighlightTextWatcher(
    private val highlight: Highlight,
    private var viewModifiedLines: Boolean = false
) : TextWatcher {

    private var start = 0
    private var end = 0

    override fun beforeTextChanged(
        actual: CharSequence,
        start: Int,
        count: Int,
        after: Int
    ) {
        this.start = start
        this.end = start + after
    }

    override fun onTextChanged(
        newText: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) {
        this.start = start
        this.end = start + count
    }

    override fun afterTextChanged(text: Editable) {
        val firstLineStart: Int = text.getFirstLineStart(start = start)
        val lastLineEnd: Int = text.getLastLineEnd(end = end)

        text.removeSpans(firstLineStart, lastLineEnd)

        highlight.applyTo(
            text = text,
            range = firstLineStart until lastLineEnd
        )

        if (viewModifiedLines) {
            Highlight(
                BackgroundColorScheme(
                    regex = "[^\n]+".toRegex(),
                    matcher = Matcher.fully(
                        UiColor.Rgb(
                            Random.nextInt(255),
                            Random.nextInt(255),
                            Random.nextInt(255)
                        )
                    )
                )
            ).applyTo(
                text = text,
                range = firstLineStart until lastLineEnd
            )
        }
    }
}
