package io.github.tomplum.kanji

import java.io.FileNotFoundException
import java.net.URL

class FileReader {
    fun read(fileName: String): URL = try {
        this::class.java.classLoader.getResource(fileName) ?: throw RuntimeException("No resource found for $fileName")
    } catch (e: FileNotFoundException) {
        throw IllegalArgumentException("Cannot find file $fileName", e)
    }
}
