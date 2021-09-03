package io.github.tomplum

import io.github.tomplum.kanji.JSONReader
import io.github.tomplum.kanji.KanjiParser
import io.github.tomplum.kanji.KanjiWriter
import io.github.tomplum.kanji.converter.DictionaryToJSONConverter
import io.github.tomplum.kanji.model.json.KanjiExample
import io.github.tomplum.kanji.model.json.Kanji
import io.github.tomplum.kanji.model.json.KanjiJson
import io.github.tomplum.kanji.model.json.ts.TypeScriptKanjiDictionary

fun main() {
    combineXmlAndTypescriptKanjiIntoJson()
}

fun combineXmlAndTypescriptKanjiIntoJson() {
    val dictionary = KanjiParser().read("kanjidic2.xml")
    val dictionaryKanji = DictionaryToJSONConverter().convert(dictionary)
    println("New Kanji Found: ${dictionaryKanji.size}")
    val total = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).sumOf {
        val quantity = dictionaryKanji.getQuantityForGrade(it)
        println("Grade $it: $quantity")
        quantity
    }
    println("Total Joyo: $total")

    val existing = JSONReader().read<TypeScriptKanjiDictionary>("existing-kanji-data.json").data
    println("Existing Kanji Found: ${existing.size}")

    val combinedKanji = dictionaryKanji.map { new ->
        val match = existing.find { it.name == new.name }
        if (match != null) {
            Kanji(
                name = new.name,
                on = match.on?.map { it.kana }?.distinct(),
                kun = match.kun?.map { it.kana }?.distinct(),
                source = match.source,
                meanings = match.meanings,
                grade = convertGrade(match.grade),
                jlpt = new.jlpt,
                strokes = new.strokes,
                examples = match.examples.map { KanjiExample(it.value, it.kana, it.english) },
                tags = match.tags
            )
        } else {
            Kanji(
                name = new.name,
                on = new.on?.distinct(),
                kun = new.kun?.distinct(),
                source = new.source,
                meanings = new.meanings?.distinct(),
                grade = new.grade,
                jlpt = new.jlpt,
                strokes = new.strokes,
                examples = new.examples,
                tags = new.tags.distinct()
            )
        }
    }

    val joyo = combinedKanji.filter { it.grade in listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12) }.sortedBy { it.grade }
    KanjiWriter().write(KanjiJson(joyo))
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

fun List<Kanji>.getQuantityForGrade(grade: Int) = this.count { it.grade == grade }
