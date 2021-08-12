package io.github.tomplum

import io.github.tomplum.kanji.JSONReader
import io.github.tomplum.kanji.KanjiParser
import io.github.tomplum.kanji.KanjiWriter
import io.github.tomplum.kanji.converter.DictionaryToJSONConverter
import io.github.tomplum.kanji.model.json.KanjiExample
import io.github.tomplum.kanji.model.json.Kanji
import io.github.tomplum.kanji.model.json.ts.TypeScriptKanjiDictionary

fun main() {
    val dictionary = KanjiParser().read("kanjidic2.xml")
    val dictionaryKanji = DictionaryToJSONConverter().convert(dictionary)
    val existing = JSONReader().read<TypeScriptKanjiDictionary>("existing-kanji-data.json").data
    val combinedKanji = dictionaryKanji.map { new ->
        val match = existing.find { it.name == new.name }
        if (match != null) {
            Kanji(
                name = new.name,
                on = new.on,
                kun = new.kun,
                source = match.source,
                meanings = match.meanings,
                grade = convertGrade(match.grade),
                jlpt = new.jlpt,
                strokes = new.strokes,
                examples = match.examples.map { KanjiExample(it.value, it.kana, it.english) },
                tags = match.tags
            )
        } else {
            new
        }
    }
    val kyoiku = combinedKanji.filter { it.grade in listOf(1, 2, 3, 4, 5, 6) }.sortedBy { it.grade }
    KanjiWriter().write(kyoiku)
}

fun convertGrade(value: String) = when(value) {
    "KyoikuGrade.ONE" -> 1
    "KyoikuGrade.TWO" -> 2
    "KyoikuGrade.THREE" -> 3
    "KyoikuGrade.FOUR" -> 4
    "KyoikuGrade.FIVE" -> 5
    "KyoikuGrade.SIX" -> 6
    else -> throw IllegalArgumentException("Unknown Kyoiku Grade: $value")
}
