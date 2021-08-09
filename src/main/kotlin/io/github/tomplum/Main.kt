package io.github.tomplum

import io.github.tomplum.kanji.KanjiParser
import io.github.tomplum.kanji.model.xml.Character

fun main() {
    val parser = KanjiParser()
    val dictionary = parser.read("kanjidic2.xml")
    val kanji = dictionary.characters
    val grade1 = kanji.filterByGrade(1)
    val grade2 = kanji.filterByGrade(2)
    val grade3 = kanji.filterByGrade(3)
    val grade4 = kanji.filterByGrade(4)
    val grade5 = kanji.filterByGrade(5)
    val grade6 = kanji.filterByGrade(6)
    val json = "";
}

fun List<Character>.filterByGrade(grade: Int) = this.filter { it.misc?.grade == grade }
