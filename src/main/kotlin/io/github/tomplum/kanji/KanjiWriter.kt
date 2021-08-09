package io.github.tomplum.kanji

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.tomplum.kanji.converter.DictionaryToJSONConverter
import io.github.tomplum.kanji.model.xml.KanjiDictionary
import java.io.File

class KanjiWriter {
    fun write(dictionary: KanjiDictionary) {
        val mapper = ObjectMapper()
        val writer = mapper.writer(DefaultPrettyPrinter())

        val kanji = DictionaryToJSONConverter().convert(dictionary)
        val kyoiku = kanji.filter { it.grade in listOf(1, 2, 3, 4, 5, 6) }.sortedBy { it.grade }

        val directory = File("generated")
        if (!directory.exists()) {
            directory.mkdir()
        }

        writer.writeValue(File("generated/kanji.json"), kyoiku)
    }
}
