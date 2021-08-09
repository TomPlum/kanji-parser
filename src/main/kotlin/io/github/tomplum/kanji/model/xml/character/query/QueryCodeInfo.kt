package io.github.tomplum.kanji.model.xml.character.query

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JsonRootName("q_code")
data class QueryCodeInfo(
    @JacksonXmlProperty(isAttribute = true, localName = "qc_type")
    var type: String?,
) {
    @JacksonXmlText
    lateinit var value: String private set
}

