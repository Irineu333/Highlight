package com.neoutils.highlight.compose.extension

import com.neoutils.highlight.core.Match

actual fun String.matchAll(
    pattern: String,
): List<Match> {

    val matches = Regex(
        pattern = pattern
    ).findAll(input = this)

    return buildList {
        matches.forEachIndexed { index, match ->
            add(
                Match(
                    index = index,
                    text = match.value,
                    range = match.range,
                    groups = match.groups.map {

                        if (it == null) return@map null

                        Match.Group(
                            text = it.value,
                            range = it.range
                        )
                    }
                )
            )
        }
    }
}
