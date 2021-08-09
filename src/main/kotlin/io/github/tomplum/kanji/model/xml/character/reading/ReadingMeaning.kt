package io.github.tomplum.kanji.model.xml.character.reading

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("reading_meaning")
data class ReadingMeaning(
    @JacksonXmlProperty(localName = "rmgroup")
    var group: ReadingMeaningGroup?,

    @JacksonXmlProperty(localName = "nanori")
    var nanori: List<String>?,
)
