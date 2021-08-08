package io.github.tomplum.kanji.model

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("dic_number")
data class DictionaryNumber(
    @JacksonXmlProperty(localName = "cp_value")
    var values: List<DictionaryReference>?
)
