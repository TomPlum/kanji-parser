package io.github.tomplum.kanji.model

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("query_code")
data class QueryCode(
    @JacksonXmlProperty(localName = "rad_value")
    var value: List<RadicalValue>?,
)
