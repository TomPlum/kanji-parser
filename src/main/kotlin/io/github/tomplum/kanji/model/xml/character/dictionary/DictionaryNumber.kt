package io.github.tomplum.kanji.model.xml.character.dictionary

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("dic_number")
data class DictionaryNumber(
    @JacksonXmlProperty(localName = "dic_ref")
    var values: List<DictionaryReference>?
)
