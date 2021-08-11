package io.github.tomplum.kanji.model.json.ts

data class TypeScriptKanji (
    val name: String,
    val on: List<TypeScriptKanjiReading>? = emptyList(),
    val kun: List<TypeScriptKanjiReading>? = emptyList(),
    val grade: String,
    val source: String,
    val meanings: List<String>? = emptyList(),
    val examples: List<TypeScriptKanjiExample> = emptyList(),
    val tags: List<String> = emptyList()
)
