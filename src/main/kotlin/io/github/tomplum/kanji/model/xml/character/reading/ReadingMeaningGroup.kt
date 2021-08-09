package io.github.tomplum.kanji.model.xml.character.reading

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonRootName("rmgroup")
data class ReadingMeaningGroup(
    @JacksonXmlProperty(localName = "reading")
    var readings: List<Reading> = emptyList(),

    @JacksonXmlProperty(localName = "meaning")
    var meanings: List<Meaning> = emptyList(),
)
