package io.github.tomplum.kanji

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.exc.MismatchedInputException
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.github.tomplum.kanji.model.xml.KanjiDictionary
import java.io.FileNotFoundException

class KanjiParser {
    fun read(fileName: String): KanjiDictionary {
        val fileURL = try {
            this::class.java.classLoader.getResource(fileName)
        } catch (e: FileNotFoundException) {
            throw IllegalArgumentException("Cannot find file $fileName", e)
        }

        val mapper = XmlMapper(JacksonXmlModule().apply { setDefaultUseWrapper(false) }).registerKotlinModule()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(JsonParser.Feature.ALLOW_COMMENTS, true)

        try {
            return mapper.readValue(fileURL)
        } catch (e: MismatchedInputException) {
            throw IllegalStateException("$fileName cannot be de-serialised", e)
        }
    }
}
