package com.neoutils.highlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.example.view.R
import com.neoutils.highlight.view.extension.textFont
import com.neoutils.highlight.view.extension.toSpannedString

class TextFontSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(context, attr) {
    init {
        text = Highlight {
            textFont {
                "\\bfont\\b"
                    .toRegex()
                    .fully(
                        checkNotNull(
                            ResourcesCompat.getFont(
                                context,
                                R.font.pacifico_regular
                            )
                        )
                    )
            }
        }.toSpannedString(
            text = "Example of font style."
        )
    }
}