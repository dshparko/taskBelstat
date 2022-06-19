package dshparko.by.belstat.task.reader.models.layout;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import dshparko.by.belstat.task.reader.models.Layout;

public class StringBlock extends LayoutRow {

    @JacksonXmlProperty(localName = "ID_DGP", isAttribute = true)
    public int referenceId;

    @JacksonXmlProperty(localName = "NUMBER_DGP", isAttribute = true)
    public int number;

    @JacksonXmlProperty(localName = "ID_UOM", isAttribute = true)
    public int idUom;

    @JacksonXmlProperty(localName = "FORMAT_UOM", isAttribute = true)
    public int formatUom;

    @JacksonXmlProperty(localName = "ISLEAF", isAttribute = true)
    public int isLeaf;

    @JacksonXmlProperty(localName = "LVL", isAttribute = true)
    public int lvl;

    @JacksonXmlProperty(localName = "ID_PARENT_DGP", isAttribute = true)
    public int idParent;

}
