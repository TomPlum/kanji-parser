package io.github.tomplum.kanji

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.tomplum.kanji.model.xml.KanjiDictionary
import java.io.File

class KanjiWriter {
    fun write(dictionary: KanjiDictionary) {
        val mapper = ObjectMapper()
        val writer = mapper.writer(DefaultPrettyPrinter())
        writer.writeValue(File("generated/kanji.json"), dictionary)
    }
}
