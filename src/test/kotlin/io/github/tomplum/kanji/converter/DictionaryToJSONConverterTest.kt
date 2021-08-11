package io.github.tomplum.kanji.converter

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.tomplum.kanji.model.json.Kanji
import io.github.tomplum.kanji.model.xml.Character
import io.github.tomplum.kanji.model.xml.KanjiDictionary
import io.github.tomplum.kanji.model.xml.character.codepoint.CodePoint
import io.github.tomplum.kanji.model.xml.character.codepoint.CodePointValue
import io.github.tomplum.kanji.model.xml.character.dictionary.DictionaryNumber
import io.github.tomplum.kanji.model.xml.character.dictionary.DictionaryReference
import io.github.tomplum.kanji.model.xml.character.misc.Miscellaneous
import io.github.tomplum.kanji.model.xml.character.query.QueryCode
import io.github.tomplum.kanji.model.xml.character.query.QueryCodeInfo
import io.github.tomplum.kanji.model.xml.character.radical.Radical
import io.github.tomplum.kanji.model.xml.character.radical.RadicalValue
import io.github.tomplum.kanji.model.xml.character.reading.Meaning
import io.github.tomplum.kanji.model.xml.character.reading.Reading
import io.github.tomplum.kanji.model.xml.character.reading.ReadingMeaning
import io.github.tomplum.kanji.model.xml.character.reading.ReadingMeaningGroup
import org.junit.jupiter.api.Test

class DictionaryToJSONConverterTest {
    @Test
    fun `Should convert valid dictionary to JSON Model`() {
        val converter = DictionaryToJSONConverter()
        val response = converter.convert(getKanjiDictionary())
        assertThat(response).isEqualTo(getExpectedJSONModel())
    }

    private fun getExpectedJSONModel(): List<Kanji> {
        return listOf(
            Kanji(
                name = "右",
                on = listOf("ウ", "ユウ"),
                kun = listOf("みぎ"),
                source = "",
                meanings = listOf("right"),
                grade = "KyoikuGrade.ONE",
                jlpt = 4,
                strokes = 5,
                examples = emptyList()
            )
        )
    }

    private fun getKanjiDictionary(): KanjiDictionary {
        val dictionary = KanjiDictionary()
        dictionary.characters = listOf(
            Character(
                literal = "右",
                codepoint = CodePoint(listOf(CodePointValue("ucs"), CodePointValue("jis208"))),
                radical = Radical(listOf(RadicalValue("classical"))),
                misc = Miscellaneous(grade = 1, strokes = 5, variant = null, freq = 602, radicalName = null, jlpt = 4),
                dictionaryNumber = DictionaryNumber(
                    listOf(
                        DictionaryReference(type = "nelson_c", volume = null, page = null),
                        DictionaryReference(type = "moro", volume = "2", page = "0769")
                    )
                ),
                queryCode = QueryCode(
                    listOf(
                        QueryCodeInfo("skip"), QueryCodeInfo("sh_desc"),
                        QueryCodeInfo("four_corner"), QueryCodeInfo("deroo")
                    )
                ),
                readingMeaning = ReadingMeaning(
                    ReadingMeaningGroup(
                        readings = getReadings(),
                        meanings = getMeanings()
                    ),
                    nanori = listOf("あき", "すけ")
                )
            )
        )
        return dictionary
    }

    private fun getReadings(): List<Reading> {
        val on1 = Reading("ja_on")
        on1.value = "ウ"

        val on2 = Reading("ja_on")
        on2.value = "ユウ"

        val kun = Reading("ja_kun")
        kun.value = "みぎ"

        return listOf(on1, on2, kun)
    }

    private fun getMeanings(): List<Meaning> {
        val meaning = Meaning("en")
        meaning.value = "right"

        val meaning2 = Meaning("fr")
        meaning2.value = "droite"

        return listOf(meaning, meaning2)
    }
}
