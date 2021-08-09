package io.github.tomplum.kanji.model.xml.header

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("header")
data class Header(
    @JacksonXmlProperty(isAttribute = true, localName = "file_version")
    var fileVersion: String?,

    @JacksonXmlProperty(isAttribute = true, localName = "database_version")
    var databaseVersion: String?,

    @JacksonXmlProperty(isAttribute = true, localName = "date_of_creation")
    var creationDate: String?
)
