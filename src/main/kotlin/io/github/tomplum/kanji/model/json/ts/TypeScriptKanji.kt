package io.github.tomplum.kanji.model.json.ts

data class TypeScriptKanji (
    var name: String,
    var on: List<TypeScriptKanjiReading>? = emptyList(),
    var kun: List<TypeScriptKanjiReading>? = emptyList(),
    var grade: String,
    var source: String,
    var meanings: List<String>? = emptyList(),
    var examples: List<TypeScriptKanjiExample> = emptyList(),
    var tags: List<String> = emptyList()
)
