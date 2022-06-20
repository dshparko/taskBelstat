package dshparko.by.belstat.task.reader.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;


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
                    id = attributes.getValue("ID_DTABLE");
                    number = attributes.getValue("NUMBER_DTABLE");
                    System.out.printf("NUMBER_DTABLE: %s%n", id, number);
                }
                if (isGraph) {


                    currency = attributes.getValue("NUMBER_DGP");
                    curren = attributes.getValue("ID_DGP");

                    System.out.printf("NUMBER_DGP :%s%n", currency, curren);
                }
                if (isRows) {
                    currenc = attributes.getValue("CODE_DROW");
                    curr = attributes.getValue("ID_DROW");

                    System.out.printf("CODE_DROW :%s%n", currenc, curr);
                }
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
        System.out.printf("End Element : %s%n", qName);

    }


}
