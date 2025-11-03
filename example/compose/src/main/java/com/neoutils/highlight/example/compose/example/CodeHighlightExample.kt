package com.neoutils.highlight.example.compose.example

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neoutils.highlight.compose.remember.rememberHighlight
import com.neoutils.highlight.compose.remember.rememberTextFieldValue
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.highlight.example.compose.R

@Composable
fun CodeHighlightExample(modifier: Modifier = Modifier) {

    val highlight = rememberHighlight {
        textColor {
            "\\b(fun)\\b"
                .toRegex()
                .fully(
                    UiColor.Hex(hex = "#E66123")
                )

            """\b(\w+)\b\((\w+\s*=)?[^)]*\)"""
                .toRegex()
                .groups(
                    UiColor.Hex(hex = "#00627A"),
                    UiColor.Hex(hex = "#548AF7"),
                )

            "@\\w+"
                .toRegex()
                .fully(
                    UiColor.Hex(hex = "#93880D")
                )

            """"[^"]*""""
                .toRegex()
                .fully(
                    UiColor.Hex(hex = "#067D17")
                )
        }
    }

    val textFieldValue = rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) {
        mutableStateOf(
            TextFieldValue(
                """
                    fun main() {
                        print("Hello, World!")
                    }
                """.trimIndent()
            )
        )
    }

    BasicTextField(
        modifier = modifier.padding(16.dp),
        value = highlight.rememberTextFieldValue(
            value = textFieldValue.value.copy(
                composition = null
            )
        ),
        onValueChange = {
            textFieldValue.value = it
        },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(
                Font(R.font.jetbrains_mono)
            )
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CodeHighlightExample()
}