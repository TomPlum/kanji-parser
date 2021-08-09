package io.github.tomplum.kanji.model.xml.character.query

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("query_code")
data class QueryCode(
    @JacksonXmlProperty(localName = "q_code")
    var info: List<QueryCodeInfo>?,
)
