package io.github.tomplum.kanji

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.kanji.model.xml.Character
import io.github.tomplum.kanji.model.xml.KanjiDictionary
import io.github.tomplum.kanji.model.xml.character.codepoint.CodePoint
import io.github.tomplum.kanji.model.xml.character.codepoint.CodePointValue
import io.github.tomplum.kanji.model.xml.character.dictionary.DictionaryNumber
import io.github.tomplum.kanji.model.xml.character.dictionary.DictionaryReference
import io.github.tomplum.kanji.model.xml.character.misc.Miscellaneous
import io.github.tomplum.kanji.model.xml.character.misc.Variant
import io.github.tomplum.kanji.model.xml.character.query.QueryCode
import io.github.tomplum.kanji.model.xml.character.query.QueryCodeInfo
import io.github.tomplum.kanji.model.xml.character.radical.Radical
import io.github.tomplum.kanji.model.xml.character.radical.RadicalValue
import io.github.tomplum.kanji.model.xml.character.reading.Meaning
import io.github.tomplum.kanji.model.xml.character.reading.Reading
import io.github.tomplum.kanji.model.xml.character.reading.ReadingMeaning
import io.github.tomplum.kanji.model.xml.character.reading.ReadingMeaningGroup
import io.github.tomplum.kanji.model.xml.header.Header
import org.junit.jupiter.api.Test

class KanjiParserTest {
    @Test
    fun `Valid XML should be parsed correctly into a KanjiDictionary object`() {
        val parser = KanjiParser()
        val dictionary = parser.read("example-kanji.xml")
        assertThat(dictionary).isEqualTo(getExpectedDictionary())
    }

    private fun getExpectedDictionary(): KanjiDictionary {
        val dictionary = KanjiDictionary()
        dictionary.header = Header("4", "2021-220", "2021-08-08")
        dictionary.characters = listOf(
            Character(
                literal = "亜",
                codepoint = getCodePoint(),
                radical = getRadicals(),
                misc = Miscellaneous(8, 7, getVariant(), 1509, null, 1),
                dictionaryNumber = getDictionaryNumber(),
                queryCode = getQueryCode(),
                readingMeaning = getReadingMeaning()
            )
        )
        return dictionary
    }

    private fun getCodePoint(): CodePoint {
        val first = CodePointValue("ucs")
        first.value = "4e9c"

        val second = CodePointValue("jis208")
        second.value = "1-16-01"

        return CodePoint(listOf(first, second))
    }

    private fun getRadicals(): Radical {
        val first = RadicalValue("classical")
        first.value = "7"

        val second = RadicalValue("nelson_c")
        second.value = "1"

        return Radical(listOf(first, second))
    }

    private fun getVariant(): Variant {
        val variant = Variant("jis208")
        variant.value = "1-48-19"
        return variant
    }

    private fun getDictionaryNumber(): DictionaryNumber {
        val ref1 = DictionaryReference("nelson_c", null, null)
        ref1.value = "42"

        val ref2 = DictionaryReference("halpern_njecd", null, null)
        ref2.value = "3540"

        val ref3 = DictionaryReference("halpern_kkd", null, null)
        ref3.value = "4354"

        return DictionaryNumber(listOf(ref1, ref2, ref3))
    }

    private fun getQueryCode(): QueryCode {
        val info1 = QueryCodeInfo("skip")
        info1.value = "4-7-1"

        val info2 = QueryCodeInfo("sh_desc")
        info2.value = "0a7.14"

        val info3 = QueryCodeInfo("four_corner")
        info3.value = "1010.6"

        val info4 = QueryCodeInfo("deroo")
        info4.value = "3273"

        return QueryCode(listOf(info1, info2, info3, info4))
    }

    private fun getReadingMeaning(): ReadingMeaning {
        val reading1 = Reading("pinyin")
        reading1.value = "ya4"

        val reading2 = Reading("korean_r")
        reading2.value = "a"

        val reading3 = Reading("korean_h")
        reading3.value = "아"

        val reading4 = Reading("vietnam")
        reading4.value = "A"

        val reading5 = Reading("ja_on")
        reading5.value = "ア"

        val reading6 = Reading("ja_kun")
        reading6.value = "つ.ぐ"

        val meaning1 = Meaning("en")
        meaning1.value = "Asia"

        val meaning2 = Meaning("fr")
        meaning2.value = "Asie"

        val meaning3 = Meaning("es")
        meaning3.value = "pref. para indicar"

        val meaning4 = Meaning("pt")
        meaning4.value = "Ásia"

        val readings = listOf(reading1, reading2, reading3, reading4, reading5, reading6)
        val meanings = listOf(meaning1, meaning2, meaning3, meaning4)
        val group = ReadingMeaningGroup(readings, meanings)

        val nanori = listOf("や", "つぎ", "つぐ")
        return ReadingMeaning(group, nanori)
    }
}
