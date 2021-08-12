package io.github.tomplum.kanji

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.tomplum.kanji.model.json.Kanji
import java.io.File

class KanjiWriter {
    fun write(kanji: List<Kanji>) {
        val mapper = ObjectMapper()
        val writer = mapper.writer(DefaultPrettyPrinter().withArrayIndenter(DefaultPrettyPrinter.FixedSpaceIndenter()))

        val directory = File("generated")
        if (!directory.exists()) {
            directory.mkdir()
        }

        writer.writeValue(File("generated/kanji.json"), kanji)
    }
}
