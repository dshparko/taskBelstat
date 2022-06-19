package dshparko.by.belstat.task.reader.models.layout;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import dshparko.by.belstat.task.reader.models.report.FreeBlock;
import dshparko.by.belstat.task.reader.models.report.StringBlock;
import dshparko.by.belstat.task.reader.models.report.ReportRow;

@JsonTypeName("1")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "TYPE_ROW")
@JsonSubTypes({@JsonSubTypes.Type(ReportRow.class), @JsonSubTypes.Type(FreeBlock.class), @JsonSubTypes.Type(StringBlock.class)}) //TODO type 4
public class LayoutRow {

    @JacksonXmlProperty(localName = "ID_DTABLE", isAttribute = true)
    public int tableId;

    @JacksonXmlProperty(localName = "NUMBER_DTABLE", isAttribute = true)
    public int numberTable;

    @JacksonXmlProperty(localName = "ORDER_DTABLE", isAttribute = true)
    public int orderTable;

    @JacksonXmlProperty(localName = "IS_PRIORITY_ROW", isAttribute = true)
    public int isPriorityRow;
}
