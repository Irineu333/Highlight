package com.neoutils.highlight.compose.extension

import com.neoutils.highlight.core.Match

expect fun String.matchAll(pattern: String): List<Match>
