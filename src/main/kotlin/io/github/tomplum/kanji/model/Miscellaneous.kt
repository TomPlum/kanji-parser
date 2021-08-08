import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import io.github.tomplum.kanji.model.Variant

@JsonRootName("misc")
data class Miscellaneous(
    @JacksonXmlProperty(localName = "grade")
    var grade: Int?,

    @JacksonXmlProperty(localName = "stroke_count")
    var strokes: Int?,

    @JacksonXmlProperty(localName = "variant")
    var variant: Variant?,

    @JacksonXmlProperty(localName = "freq")
    var freq: Int?,

    @JacksonXmlProperty(localName = "rad_name")
    var radicalName: String?,

    @JacksonXmlProperty(localName = "jlpt")
    var jlpt: Int?,
);
