package io.github.tomplum.kanji.model.json

data class Kanji(
    val name: String,
    val on: List<String>? = emptyList(),
    val kun: List<String>? = emptyList(),
    val source: String,
    val meanings: List<String>? = emptyList(),
    val grade: Int?,
    val jlpt: Int?,
    val strokes: Int?,
    val examples: List<String> = emptyList()
)
