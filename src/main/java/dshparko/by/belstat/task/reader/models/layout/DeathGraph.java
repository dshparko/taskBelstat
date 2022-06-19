package dshparko.by.belstat.task.reader.models.layout;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DeathGraph {


    @JacksonXmlProperty(localName = "ID_DGC", isAttribute = true)
    public int id;

    @JacksonXmlProperty(localName = "ID_DROW", isAttribute = true)
    public int idDrow;

    @JacksonXmlProperty(localName = "ID_DGP", isAttribute = true)
    public int idDgp;

    @JacksonXmlProperty(localName = "ID_REF", isAttribute = true)
    public int idRef;

}
