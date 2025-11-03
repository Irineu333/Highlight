package com.neoutils.highlight.core

data class Match(
    val index: Int,
    val range: IntRange,
    val text: String,
    val groups: List<Group?>
) {
    data class Group(
        val text: String,
        val range: IntRange
    )
}