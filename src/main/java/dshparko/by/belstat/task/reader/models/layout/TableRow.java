package dshparko.by.belstat.task.reader.models.layout;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TableRow {


    @JacksonXmlProperty(localName = "ID_DROW", isAttribute = true)
    public int referenceId;

    @JacksonXmlProperty(localName = "CODE_DROW", isAttribute = true)
    public int code;

    @JacksonXmlProperty(localName = "NUMBER_DROW", isAttribute = true)
    public int number;

    @JacksonXmlProperty(localName = "TYPE_ROW", isAttribute = true)
    public int rowType;


    @JacksonXmlProperty(localName = "IS_FILL_FULL_RESULT", isAttribute = true)
    public int isFull;

    @JacksonXmlProperty(localName = "ID_REFLST", isAttribute = true)
    public int idRef;

}
