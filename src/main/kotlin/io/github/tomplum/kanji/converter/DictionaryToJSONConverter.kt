package io.github.tomplum.kanji.converter

import io.github.tomplum.kanji.model.json.Kanji
import io.github.tomplum.kanji.model.xml.KanjiDictionary

class DictionaryToJSONConverter {
    fun convert(dictionary: KanjiDictionary): List<Kanji> = dictionary.characters.map { character ->
        Kanji(
            source = "",
            name = character.literal,
            jlpt = character.misc?.jlpt,
            grade = character.misc?.grade,
            strokes = character.misc?.strokes,
            on = character.readingMeaning?.group?.readings?.filter { it.type === "ja_on" }?.map { it.value },
            kun = character.readingMeaning?.group?.readings?.filter { it.type === "ja_kun" }?.map { it.value },
            meanings = character.readingMeaning?.group?.meanings?.filter { it.language === "en" }?.map { it.value },
        )
    }
}
