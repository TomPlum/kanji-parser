package io.github.tomplum.kanji.model.xml.character.radical

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("radical")
data class Radical(
    @JacksonXmlProperty(localName = "rad_value")
    var value: List<RadicalValue>?,
)
