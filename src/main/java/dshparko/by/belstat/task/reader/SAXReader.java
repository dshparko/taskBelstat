package dshparko.by.belstat.task.reader;

import dshparko.by.belstat.task.reader.models.Layout;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class SAXReader extends DefaultHandler {

    Layout layout;

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
        layout = new Layout();
        System.out.printf("Start Element : %s%n", qName);

        if (qName.equals("row")) {
            String id = attributes.getValue("NUMBER_DTABLE");
            String currency = attributes.getValue("NUMBER_DGP");
            String currenc = attributes.getValue("CODE_DROW");
            System.out.printf("NUMBER_DTABLE: %s%n", id);
            System.out.printf("NUMBER_DGP :%s%n", currency);
            System.out.printf("CODE_DROW :%s%n", currenc);
        }



    }

    @Override
    public void endElement(String uri,
                           String localName,
                           String qName) {

        System.out.printf("End Element : %s%n", qName);

    }

}
