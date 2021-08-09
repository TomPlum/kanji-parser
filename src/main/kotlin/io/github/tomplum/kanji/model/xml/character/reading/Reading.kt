package io.github.tomplum.kanji.model.xml.character.reading

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JsonRootName("reading")
data class Reading(
    @JacksonXmlProperty(isAttribute = true, localName = "r_type")
    var type: String?,
) {
    @JacksonXmlText
    lateinit var value: String private set
}

