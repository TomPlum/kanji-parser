package io.github.tomplum

import io.github.tomplum.kanji.KanjiParser
import io.github.tomplum.kanji.KanjiWriter
import io.github.tomplum.kanji.model.xml.Character

fun main() {
    val dictionary = KanjiParser().read("kanjidic2.xml")
    KanjiWriter().write(dictionary)
}
