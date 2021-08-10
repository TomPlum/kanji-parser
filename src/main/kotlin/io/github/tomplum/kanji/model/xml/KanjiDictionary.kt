package io.github.tomplum.kanji.model.xml

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import io.github.tomplum.kanji.model.xml.header.Header

@JacksonXmlRootElement(localName = "kanjidic2")
class KanjiDictionary {
    @JacksonXmlProperty(localName = "header")
    var header: Header? = null

    private val foundCharacters = mutableListOf<Character>()

    /**
     * It is necessary to do it this way as Jackson gets confused and overwrites
     * some elements and ~50% were being lost.
     * See: https://github.com/FasterXML/jackson-dataformat-xml/issues/363
     */
    @JacksonXmlProperty(localName = "character")
    var characters: List<Character> = mutableListOf()
        set(value) {
            value.forEach { foundCharacters.add(it) }
            field = foundCharacters
        }

    override fun toString(): String {
        return "KanjiDictionary(header=$header, characters=$characters)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KanjiDictionary

        if (header != other.header) return false
        if (characters != other.characters) return false

        return true
    }

    override fun hashCode(): Int {
        var result = header?.hashCode() ?: 0
        result = 31 * result + characters.hashCode()
        return result
    }
}
