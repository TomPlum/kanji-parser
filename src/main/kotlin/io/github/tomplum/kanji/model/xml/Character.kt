package io.github.tomplum.kanji.model.xml

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import io.github.tomplum.kanji.model.xml.character.codepoint.CodePoint
import io.github.tomplum.kanji.model.xml.character.dictionary.DictionaryNumber
import io.github.tomplum.kanji.model.xml.character.misc.Miscellaneous
import io.github.tomplum.kanji.model.xml.character.query.QueryCode
import io.github.tomplum.kanji.model.xml.character.radical.Radical
import io.github.tomplum.kanji.model.xml.character.reading.ReadingMeaning

@JsonRootName("character")
data class Character(
    @JacksonXmlProperty(localName = "literal")
    var literal: String?,

    @JacksonXmlProperty(localName = "codepoint")
    var codepoint: CodePoint?,

    @JacksonXmlProperty(localName = "radical")
    var radical: Radical?,

    @JacksonXmlProperty(localName = "misc")
    var misc: Miscellaneous?,

    @JacksonXmlProperty(localName = "dic_number")
    var dictionaryNumber: DictionaryNumber?,

    @JacksonXmlProperty(localName = "query_code")
    var queryCode: QueryCode?,

    @JacksonXmlProperty(localName = "reading_meaning")
    var readingMeaning: ReadingMeaning?,
)
