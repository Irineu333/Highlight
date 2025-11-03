package com.neoutils.highlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.backgroundColor
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.highlight.view.extension.toSpannedString

class BackgroundSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    context,
    attr
) {
    init {
        text = Highlight {
            backgroundColor {
                "\\bcolor\\b"
                    .toRegex()
                    .fully(
                        UiColor.Blue
                    )
            }
            textColor {
                "\\bcolor\\b"
                    .toRegex()
                    .fully(
                        UiColor.White
                    )
            }
        }.toSpannedString(
            text = "Example of background color."
        )
    }
}
