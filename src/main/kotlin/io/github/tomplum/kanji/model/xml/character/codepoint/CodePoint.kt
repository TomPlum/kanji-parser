package io.github.tomplum.kanji.model.xml.character.codepoint

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("codepoint")
data class CodePoint(
    @JacksonXmlProperty(localName = "cp_value")
    var value: List<CodePointValue>
)
