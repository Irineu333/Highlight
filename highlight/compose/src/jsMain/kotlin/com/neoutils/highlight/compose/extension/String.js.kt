package com.neoutils.highlight.compose.extension

import com.neoutils.highlight.core.Match
import kotlin.js.RegExp

actual fun String.matchAll(
    pattern: String
): List<Match> {

    val jsRegex = RegExp(pattern = pattern, flags = "gd")

    val matches = matchAll(jsRegex)

    return buildList {
        matches.forEachIndexed { index, match ->

            val indices = match.indices
            val groupsWithIndex = match.iterator().withIndex()

            add(
                Match(
                    index = index,
                    text = match.toString(),
                    range = indices[0].unsafeCast<IntArray>().toRange(),
                    groups = buildList {
                        groupsWithIndex.forEach { (index, group) ->
                            val range = indices[index]?.unsafeCast<IntArray>()

                            add(
                                range?.let {
                                    Match.Group(
                                        text = group.unsafeCast<String>(),
                                        range = range.toRange()
                                    )
                                }
                            )
                        }
                    }
                )
            )
        }
    }
}

fun String.matchAll(jsRegex: RegExp): List<dynamic> {

    val result = asDynamic().matchAll(jsRegex)

    return buildList {
        var current = result.next()

        while (current.done == false) {
            add(current.value)
            current = result.next()
        }
    }
}
