package io.github.tomplum.kanji

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.tomplum.kanji.converter.DictionaryToJSONConverter
import io.github.tomplum.kanji.model.xml.KanjiDictionary
import java.io.File

class KanjiWriter {
    fun write(dictionary: KanjiDictionary) {
        val mapper = ObjectMapper()
        val writer = mapper.writer(DefaultPrettyPrinter("\n"))

        val kanji = DictionaryToJSONConverter().convert(dictionary)
        val kyoiku = kanji.filter { it.grade in listOf(1, 2, 3, 4, 5, 6).map { it.toGrade() } }.sortedBy { it.grade }

        val directory = File("generated")
        if (!directory.exists()) {
            directory.mkdir()
        }

        writer.writeValue(File("generated/kanji.json"), kyoiku)
    }

    private fun Int.toGrade() = when(this) {
        1 -> "ONE"
        2 -> "TWO"
        3 -> "THREE"
        4 -> "FOUR"
        5 -> "FIVE"
        6 -> "SIX"
        else -> "UNKNOWN"
    }.let { "KyoikuGrade.{$it}" }
}
