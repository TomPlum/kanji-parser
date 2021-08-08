package io.github.tomplum.kanji.model

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JsonRootName("dic_ref")
data class DictionaryReference(
    @JacksonXmlProperty(isAttribute = true, localName = "dr_type")
    var type: String?,

    @JacksonXmlProperty(isAttribute = true, localName = "m_vol")
    var volume: String?,

    @JacksonXmlProperty(isAttribute = true, localName = "m_page")
    var page: String?,
) {
    @JacksonXmlText
    lateinit var value: String private set
}
