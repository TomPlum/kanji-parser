package io.github.tomplum.kanji.model.xml.character.radical

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JsonRootName("rad_value")
data class RadicalValue(
    @JacksonXmlProperty(isAttribute = true, localName = "rad_type")
    var type: String?,
) {
    @JacksonXmlText
    lateinit var value: String
}

