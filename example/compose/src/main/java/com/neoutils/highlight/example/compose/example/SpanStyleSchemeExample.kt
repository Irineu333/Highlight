package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.spanStyle
import com.neoutils.highlight.compose.remember.rememberAnnotatedString
import com.neoutils.highlight.compose.remember.rememberHighlight

@Composable
fun SpanStyleSchemeExample() {

    val annotatedString = rememberHighlight {
        spanStyle {
            "\\bstyled\\b"
                .toRegex()
                .fully(
                    SpanStyle(
                        color = Color.White,
                        background = Color.Black,
                        fontStyle = FontStyle.Italic,
                        textDecoration = TextDecoration.LineThrough,
                    )
                )
        }
    }.rememberAnnotatedString(
        text = "Example of styled text."
    )

    Text(text = annotatedString)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SpanStyleSchemeExample()
}