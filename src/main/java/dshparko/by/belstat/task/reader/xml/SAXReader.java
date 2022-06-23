package dshparko.by.belstat.task.reader.xml;

import dshparko.by.belstat.task.reader.xml.models.TemplateGraph;
import dshparko.by.belstat.task.reader.xml.models.TemplateRow;
import dshparko.by.belstat.task.reader.xml.models.TemplateTable;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


public class SAXReader extends DefaultHandler {


    private static final String TABLES = "TABLES";
    private static final String GRAPH_PROGRAPH = "GRAPH_PROGRAPH";
    private static final String ROW_IN_TABLE = "ROW_IN_TABLE";
    private static final String DEATH_GRAPH_CELL = "DEATH_GRAPH_CELL";
    private boolean isTable = false;
    private boolean isRows = false;
    private boolean isGraph = false;
    private boolean isCell = false;
    String id, currency, currenc, number, curren, curr;


    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

    TemplateTable t = new TemplateTable();

    TemplateGraph g = new TemplateGraph();
    TemplateRow r = new TemplateRow();

    ArrayList<TemplateTable> table = new ArrayList<>();
    ArrayList<TemplateRow> rows = new ArrayList<>();
    ArrayList<TemplateGraph> graphListWrapper = new ArrayList<>();

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {
        switch (qName) {
            case TABLES -> isTable = true;
            case GRAPH_PROGRAPH -> isGraph = true;
            case ROW_IN_TABLE -> isRows = true;
            case DEATH_GRAPH_CELL -> isCell = true;
        }
        System.out.printf("Start Element : %s%n", qName);

        if (isTable) {
            if (qName.equals("row")) {
                if (!isGraph && !isRows && !isCell) {
                    t.setId(Integer.parseInt(attributes.getValue("ID_DTABLE")));
                    t.setNumber(Integer.parseInt(attributes.getValue("NUMBER_DTABLE")));
                    t.setName(attributes.getValue("NAME_DPART"));

                }
                if (isGraph) {

                    ArrayList<TemplateGraph> graphListWrapper = new ArrayList<>();
                    g.setId(Integer.parseInt(attributes.getValue("ID_DGP")));
                    g.setNumber(Integer.parseInt(attributes.getValue("ID_DGP")));

                }
                if (isRows) {
                    r.setId(Integer.parseInt(attributes.getValue("ID_DROW")));
                    r.setCode((attributes.getValue("CODE_DROW")));

                }
                rows.add(r);
                graphListWrapper.add(g);
                table.add(t);
            }
        }

    }

    @Override
    public void endElement(String uri,
                           String localName,
                           String qName) {
        switch (qName) {
            case TABLES -> isTable = false;
            case GRAPH_PROGRAPH -> isGraph = false;
            case ROW_IN_TABLE -> isRows = false;
            case DEATH_GRAPH_CELL -> isCell = false;
        }
        // for (TemplateTable templateTable : table) System.out.println(templateTable.getId());

        // for (TemplateGraph templateGraph : graphListWrapper) System.out.println(templateGraph.getNumber());
        // for (TemplateRow templateRow : rows) System.out.println(templateRow.getCode());
        System.out.printf("End Element : %s%n", qName);

    }


}
