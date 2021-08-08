package io.github.tomplum.kanji.model

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JsonRootName("cp_value")
data class CodePointValue(
    @JacksonXmlProperty(isAttribute = true, localName = "cp_type")
    var type: String?,
) {
    @JacksonXmlText
    lateinit var value: String private set
}
