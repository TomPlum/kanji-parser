package io.github.tomplum.kanji.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "kanjidic2")
data class KanjiDictionary(
    @JacksonXmlProperty(localName = "header")
    var header: Header? = null,

    @JacksonXmlProperty(localName = "character")
    var character: Character? = null
)
