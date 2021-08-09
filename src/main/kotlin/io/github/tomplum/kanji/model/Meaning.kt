package io.github.tomplum.kanji.model

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JsonRootName("meaning")
data class Meaning(
    @JacksonXmlProperty(isAttribute = true, localName = "m_lang")
    var language: String = "en",
) {
    @JacksonXmlText
    lateinit var value: String private set
}

