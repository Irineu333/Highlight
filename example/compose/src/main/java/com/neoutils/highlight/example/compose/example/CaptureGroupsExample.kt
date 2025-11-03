package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.remember.rememberAnnotatedString
import com.neoutils.highlight.compose.remember.rememberHighlight
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.util.UiColor

@Composable
fun CaptureGroupsExample() {

    val annotatedString = rememberHighlight {
        textColor {
            """("\w+")\s*=\s*("\w+")"""
                .toRegex()
                .groups(
                    UiColor.Blue,
                    UiColor.Green
                )
        }
    }.rememberAnnotatedString(
        text = """
            "name" = "Irineu"
        """.trimIndent()
    )

    Text(text = annotatedString)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CaptureGroupsExample()
}