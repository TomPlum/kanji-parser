package io.github.tomplum.kanji.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "kanjidic2")
class KanjiDictionary {
    @JacksonXmlProperty(localName = "header")
    var header: Header? = null

    private val foundCharacters = mutableListOf<Character>()

    /**
     * Is necessary to do it this way as Jackson gets confused and overwrites
     * some elements and ~50% were being lost.
     * See: https://github.com/FasterXML/jackson-dataformat-xml/issues/363
     */
    @JacksonXmlProperty(localName = "character")
    var characters: List<Character> = mutableListOf()
        set(value) {
            value.forEach { foundCharacters.add(it) }
            field = foundCharacters
        }
}
